#* «Copyright 2025 Roberto Reinosa Fernández»
#*
#* This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
# You should have received a copy of the GNU General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.
#*

entrada = input("Enter input file: ")

archivoEntrada = open(entrada, 'r')

listaEntrada = []

verdaderosPositivos = 0
verdaderosNegativos = 0
falsosPositivos = 0
falsosNegativos = 0
contadorTotales = 0

for linea in archivoEntrada:

    contadorTotales += 1

    listaEntrada = linea.strip().split(";")

    if listaEntrada[len(listaEntrada)-1] == "POSITIVE" and listaEntrada[len(listaEntrada)-2] == "1":

        verdaderosPositivos += 1

    elif listaEntrada[len(listaEntrada)-1] == "NEGATIVE" and listaEntrada[len(listaEntrada)-2] == "0":

        verdaderosNegativos += 1

    elif listaEntrada[len(listaEntrada)-1] == "POSITIVE" and listaEntrada[len(listaEntrada)-2] == "0":

        falsosPositivos += 1

    elif listaEntrada[len(listaEntrada) - 1] == "NEGATIVE" and listaEntrada[len(listaEntrada) - 2] == "1":

        falsosNegativos += 1

archivoEntrada.close()

print("True Positives ", verdaderosPositivos)
print("True Negatives ", verdaderosNegativos)
print("False Positives ", falsosPositivos)
print("False Negatives ", falsosNegativos)
print()
print("Sensitivity ", verdaderosPositivos/(verdaderosPositivos + falsosNegativos))
print("Specificity ", verdaderosNegativos/(verdaderosNegativos + falsosPositivos))
print("Overall Accuracy ", (verdaderosPositivos + verdaderosNegativos)/contadorTotales)
