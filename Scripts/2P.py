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
from scipy.optimize import dual_annealing
import warnings

warnings.filterwarnings("ignore")

def logistica_2p(x, k, x0):
    arg = -k * (x - x0)
    arg = np.clip(arg, -100, 100)
    return 1 / (1 + np.exp(arg))


def calcular_r2(y_real, y_predicho):
    residuos = y_real - y_predicho
    ss_res = np.sum(residuos ** 2)
    ss_tot = np.sum((y_real - np.mean(y_real)) ** 2)
    if ss_tot == 0: return 0.0
    return 1 - (ss_res / ss_tot)


def funcion_objetivo(params, x_data, y_data):
    k, x0 = params
    y_pred = logistica_2p(x_data, k, x0)
    return np.sum((y_data - y_pred) ** 2)


print("\n=== OPTIMIZATION (DUAL ANNEALING) - 2 PARAMETERS ===")
entrada = input("Upload raw data file (Semicolon-separated CSV): ").strip()
salida_img = input("Filename for plot export (e.g., plot.png): ").strip()

print(f"Reading {entrada}...")
try:
    f = open(entrada, "r")
except:
    print("File Error.")
    exit()

positivos = []
negativos = []
vals = set()
for l in f:
    l = l.strip()
    if not l: continue
    try:
        p = l.split(";")
        v = float(p[0].replace(",", "."))
        c = int(float(p[1]))
        vals.add(v)
        if c == 0:
            negativos.append(v)
        else:
            positivos.append(v)
    except:
        continue

f.close()

positivos.sort()
negativos.sort()
umbrales = sorted(list(vals))
x_v, y_se, y_sp = [], [], []
tp_tot, tn_tot = len(positivos), len(negativos)

for c in umbrales:
    tp = sum(1 for p in positivos if p >= c)
    tn = sum(1 for n in negativos if n < c)
    x_v.append(c)
    y_se.append(tp / tp_tot if tp_tot else 0)
    y_sp.append(tn / tn_tot if tn_tot else 0)

x_data = np.array(x_v)
y_sens_data = np.array(y_se)
y_spec_data = np.array(y_sp)

min_x, max_x = min(x_data), max(x_data)

bounds = [(-2000, 2000), (min_x, max_x)]


def ajustar_nuclear(x, y, nombre):
    print(f"   > Deeply optimizing {nombre}...", end="", flush=True)

    res = dual_annealing(
        funcion_objetivo,
        bounds=bounds,
        args=(x, y),
        maxiter=3000,
        initial_temp=5000,
        visit=2.6,
        no_local_search=False
    )

    popt = res.x
    r2 = calcular_r2(y, logistica_2p(x, *popt))
    print(f" Done. R2: {r2:.6f}")
    return popt, r2


popt_sens, r2_sens = ajustar_nuclear(x_data, y_sens_data, "Sensitivity")
popt_spec, r2_spec = ajustar_nuclear(x_data, y_spec_data, "Specificity")

k_sens, x0_sens = popt_sens
k_spe, x0_spe = popt_spec

try:
    cruce_x = (k_sens * x0_sens - k_spe * x0_spe) / (k_sens - k_spe)
    cruce_y = logistica_2p(cruce_x, k_sens, x0_sens)
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
print(f"Sens: k={k_sens:.4f}, x0={x0_sens:.4f}")
print(f"Spec: k={k_spe:.4f}, x0={x0_spe:.4f}")
print("=" * 45)

plt.figure(figsize=(12, 7))
plt.scatter(x_data, y_sens_data, color='blue', s=15, alpha=0.2, label='Empirical Sens.')
plt.scatter(x_data, y_spec_data, color='orange', s=15, alpha=0.2, label='Empirical Spec.')

x_suave = np.linspace(min(x_data), max(x_data), 2000)
plt.plot(x_suave, logistica_2p(x_suave, *popt_sens), 'b-', lw=2, label=f'Sens ($R^2={r2_sens:.3f}$)')
plt.plot(x_suave, logistica_2p(x_suave, *popt_spec), 'C1-', lw=2, label=f'Spec ($R^2={r2_spec:.3f}$)')

plt.plot(cruce_x, cruce_y, 'ro', markersize=10, zorder=5, label='Analytical Intersection')
plt.annotate(f"{cruce_x:.2f}", (cruce_x, cruce_y), xytext=(cruce_x, cruce_y + 0.15),
             arrowprops=dict(facecolor='black', shrink=0.05), ha='center', fontsize=12, fontweight='bold')

plt.title('2-Variable Optimization (Dual Annealing)')
plt.legend()
plt.grid(True, alpha=0.3)
plt.savefig(salida_img)
plt.show()
