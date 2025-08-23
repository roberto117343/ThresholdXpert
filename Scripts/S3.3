#* «Copyright 2025 Roberto Reinosa Fernández»
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


import math
import random
import matplotlib.pyplot as plt

def calcular_r2(y_observado, y_predicho):

    if len(y_observado) != len(y_predicho):

        raise ValueError("The lists y_observado and y_predicho must have the same length.")

    media_y = sum(y_observado) / len(y_observado)

    ss_res = sum((y_observado[i] - y_predicho[i]) ** 2 for i in range(len(y_observado)))

    ss_tot = sum((y - media_y) ** 2 for y in y_observado)

    r2 = 1 - (ss_res / ss_tot)
    return r2

def funcion_logistica(x, k, x0):

    y = (1/(1.0 + pow(math.e, -k * (x - x0))))
    return y

entrada = input("Enter input file: ")
salida = input("Enter plot save file: ")

limite_inferior_k = float(input("Enter lower bound for k: "))
limite_superior_k = float(input("Enter upper bound for k: "))

limite_inferior_x0 = float(input("Enter lower bound for x0: "))
limite_superior_x0 = float(input("Enter upper bound for x0: "))

f = open(entrada, "r")

x1 = []
y1 = []

while True:

    linea = f.readline()

    if not linea:

        break

    x1.append(float(linea.split(";")[0]))
    y1.append(float(linea.split(";")[1]))

f.close()

entrada = True
r2_temporal = -100000000000
exception = False

k = random.uniform(limite_inferior_k, limite_superior_k)
x0 = random.uniform(limite_inferior_x0, limite_superior_x0)

contador_fallos = 0
contador_aciertos = 0

contador_saltos = 0

for n in range(10000000000):

    valor1 = random.randint(0, 1)
    valor2 = random.randint(0, 1)

    if valor1 == 0:

        k_prueba = k + 0.01

    else:

        k_prueba = k - 0.01

    if valor2 == 0:

        x0_prueba = x0 + 0.01

    else:

        x0_prueba = x0 - 0.01

    x = []
    y = []

    contador = 0

    while contador < len(x1):

        try:

            y.append(funcion_logistica(x1[contador], k_prueba, x0_prueba))

        except:

            exception = True
            break

        contador += 1

    if exception:

        k = random.uniform(limite_inferior_k, limite_superior_k)
        x0 = random.uniform(limite_inferior_x0, limite_superior_x0)
        contador_fallos = 0
        exception = False
        continue

    r2 = calcular_r2(y1, y)

    if r2 > r2_temporal:

        r2_temporal = r2
        entrada = True
        k = k_prueba
        x0 = x0_prueba
        contador_fallos = 0
        contador_aciertos += 1

    else:

        entrada = False
        contador_fallos += 1

    if contador_fallos >= 200:

        k = random.uniform(limite_inferior_k, limite_superior_k)
        x0 = random.uniform(limite_inferior_x0, limite_superior_x0)
        contador_fallos = 0
        contador_saltos += 1

    if contador_saltos == 1500:

        break

    if entrada:

        print("----------------------------------------")

        k_final = k
        x0_final = x0
        r2_final = r2

        print("k = ", k)
        print("x0 = ", x0)
        print("R2 = ", r2)

plt.figure()

y = []

variable = 0

while variable <= x1[len(x1)-1]:

    y.append(funcion_logistica(variable, k_final, x0_final))
    x.append(variable)
    variable += 0.1

plt.plot(x, y, marker='o', linestyle='-', color='b', label="Calculate")
plt.plot(x1, y1, marker='o', linestyle='None', color='C1', label="Empirical")

plt.xlabel('Threshold')
plt.ylabel('Sensitivity or Specificity')
plt.title('Sensitivity or Specificity Fitting')
plt.legend()
plt.savefig(salida)
plt.show()

print("-------------------------------")

print("\nResult:\n")

print("f(x) = 1/(1 + e^(-" + str(k_final) + "(x - " + str(x0_final) + ")))" + "\n")

print("k = ",  k_final)
print("x0 = ", x0_final)
print("R2 = ", r2_final)
