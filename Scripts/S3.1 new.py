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

import matplotlib.pyplot as plt
import numpy as np

entrada = input("Enter input file: ")

f = open(entrada, "r")

positivos = []
negativos = []

totales = []

for linea in f:

    linea_cortada = linea.strip().split(";")

    if linea_cortada[1] == "0":

        negativos.append(float(linea_cortada[0]))

    else:

        positivos.append(float(linea_cortada[0]))

    totales.append(float(linea_cortada[0]))

f.close()

positivos_ordenados = sorted(positivos)
negativos_ordenados = sorted(negativos)
totales = sorted(totales)

sensibilidad = []
especificidad = []

for i in range(0, len(positivos_ordenados)):

    contador_sensibilidad = 0

    for x in range(0, len(positivos_ordenados)):

        if positivos_ordenados[i] <= positivos_ordenados[x]:

            contador_sensibilidad += 1

    sensibilidad.append(contador_sensibilidad/len(positivos_ordenados))


for i in range(0, len(negativos_ordenados)):

    contador_especificidad = 0

    for x in range(0, len(negativos_ordenados)):

        if negativos_ordenados[i] > negativos_ordenados[x]:

            contador_especificidad += 1

    especificidad.append((contador_especificidad/len(negativos_ordenados)))

min_val = totales[0]
max_val = totales[-1]
x_comun = np.linspace(min_val, max_val, 5000)

y_sens = np.interp(x_comun, positivos_ordenados, sensibilidad)
y_spec = np.interp(x_comun, negativos_ordenados, especificidad)

indice_cruce = np.argmin(np.abs(y_sens - y_spec))

valor_cruce_x = x_comun[indice_cruce]
valor_cruce_y = y_sens[indice_cruce]

print("\n" + "="*40)
print(f"Numerical intersection threshold: {valor_cruce_x}")
print(f"Sensitivity/Specificity at the intersection point: {valor_cruce_y}")
print("="*40 + "\n")
