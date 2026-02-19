#* «Copyright 2026 Roberto Reinosa Fernández»
#*
#* This program is free software: you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation, either version 3 of the License, or
#  (at your option) any later version.
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  You should have received a copy of the GNU General Public License
#  along with this program.  If not, see <http://www.gnu.org/licenses/>.
#*

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import dual_annealing, fsolve
import warnings

warnings.filterwarnings("ignore")


def logistica_4p(x, L, A, k, x0):
    arg = -k * (x - x0)
    arg = np.clip(arg, -100, 100)
    return L + A / (1 + np.exp(arg))


def calcular_r2(y_real, y_predicho):
    residuos = y_real - y_predicho
    ss_res = np.sum(residuos ** 2)
    ss_tot = np.sum((y_real - np.mean(y_real)) ** 2)
    if ss_tot == 0: return 0.0
    return 1 - (ss_res / ss_tot)


def funcion_objetivo(params, x_data, y_data):
    L, A, k, x0 = params
    y_pred = logistica_4p(x_data, L, A, k, x0)
    return np.sum((y_data - y_pred) ** 2)


print("\n=== OPTIMIZATION (DUAL ANNEALING) - 4 VARIABLES ===")
print("NOTE: This process may take a few seconds/minutes to ensure maximum precision.")
entrada = input("Enter raw data file (CSV with semicolon delimiter): ").strip()
salida_img = input("Filename to save the plot (e.g., plot.png): ").strip()

print(f"Reading {entrada}...")

try:
    f = open(entrada, "r")
except FileNotFoundError:
    print("Error: File not found.")
    exit()

positivos = []
negativos = []
todos_los_valores = set()

for linea in f:
    linea = linea.strip()
    if not linea: continue
    try:
        partes = linea.split(";")
        valor = float(partes[0].replace(",", "."))
        clase = int(float(partes[1]))
        todos_los_valores.add(valor)
        if clase == 0:
            negativos.append(valor)
        else:
            positivos.append(valor)
    except:
        continue
f.close()

positivos.sort()
negativos.sort()
umbrales = sorted(list(todos_los_valores))

x_vals, y_sens, y_spec = [], [], []
total_pos = len(positivos)
total_neg = len(negativos)

for corte in umbrales:
    tp = sum(1 for p in positivos if p >= corte)
    sens = tp / total_pos if total_pos > 0 else 0
    tn = sum(1 for n in negativos if n < corte)
    spec = tn / total_neg if total_neg > 0 else 0
    x_vals.append(corte)
    y_sens.append(sens)
    y_spec.append(spec)

x_data = np.array(x_vals)
y_sens_data = np.array(y_sens)
y_spec_data = np.array(y_spec)

min_x, max_x = min(x_data), max(x_data)
bounds = [(-0.1, 1.1), (0.0, 1.2), (-1000, 1000), (min_x, max_x)]


def ajustar_nuclear(x, y, nombre):
    print(f"   > Searching for optimal fit for {nombre}...", end="", flush=True)

    resultado = dual_annealing(
        funcion_objetivo,
        bounds=bounds,
        args=(x, y),
        maxiter=2000,
        initial_temp=5000,
        visit=2.5
    )

    popt = resultado.x
    r2 = calcular_r2(y, logistica_4p(x, *popt))
    print(f" Done. R2: {r2:.6f}")
    return popt, r2


popt_sens, r2_sens = ajustar_nuclear(x_data, y_sens_data, "Sensitivity")
popt_spec, r2_spec = ajustar_nuclear(x_data, y_spec_data, "Specificity")


def encontrar_cruce(x):
    return logistica_4p(x, *popt_sens) - logistica_4p(x, *popt_spec)


start_point = (popt_sens[3] + popt_spec[3]) / 2
try:
    cruce_x = fsolve(encontrar_cruce, start_point)[0]
    cruce_y = logistica_4p(cruce_x, *popt_sens)
except:
    cruce_x, cruce_y = 0, 0

print("\n" + "=" * 45)
print(" RESULTS")
print("=" * 45)
print(f"Optimal Cut-off Point : {cruce_x:.5f}")
print(f"Sensitivity/Specificity : {cruce_y:.5f}")
print("-" * 45)
print(f"R² Sensitivity : {r2_sens:.6f}")
print(f"R² Specificity : {r2_spec:.6f}")
print("-" * 45)
print(f"Sens Params [L, A, k, x0]: {np.round(popt_sens, 3)}")
print(f"Spec Params [L, A, k, x0]: {np.round(popt_spec, 3)}")
print("=" * 45)

plt.figure(figsize=(12, 7))
plt.scatter(x_data, y_sens_data, color='blue', s=15, alpha=0.2, label='Empirical Sens.')
plt.scatter(x_data, y_spec_data, color='orange', s=15, alpha=0.2, label='Empirical Spec.')

x_suave = np.linspace(min(x_data), max(x_data), 2000)
plt.plot(x_suave, logistica_4p(x_suave, *popt_sens), 'b-', lw=2, label=f'Sens ($R^2={r2_sens:.3f}$)')
plt.plot(x_suave, logistica_4p(x_suave, *popt_spec), 'C1-', lw=2, label=f'Spec ($R^2={r2_spec:.3f}$)')

plt.plot(cruce_x, cruce_y, 'ro', markersize=10, zorder=5, label='Cruce')
plt.annotate(f"{cruce_x:.2f}", (cruce_x, cruce_y), xytext=(cruce_x, cruce_y + 0.15),
             arrowprops=dict(facecolor='black', shrink=0.05), ha='center', fontsize=12, fontweight='bold')

plt.title('4-Variable Optimization (Dual Annealing)')
plt.legend()
plt.grid(True, alpha=0.3)
plt.savefig(salida_img)
plt.show()
