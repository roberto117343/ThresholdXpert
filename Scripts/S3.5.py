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

def funcion_calculo_sen_esp(y, k, x0):

    resultado = (math.log((1/y)-1)/-k) + x0
    return resultado


def funcion_logistica(x, k, x0):

    y = (1/(1.0 + pow(math.e, -k * (x - x0))))
    return y

k_fijado = float(input("Enter k for the fixed parameter: "))
x0_fijado = float(input("Enter x0 for the fixed parameter: "))

k_calculado = float(input("Enter k for the calculated parameter: "))
x0_calculado = float(input("Enter x0 for the calculated parameter: "))

metrica = float(input("Enter the target value for the fixed parameter: "))

resultado = funcion_calculo_sen_esp(metrica, k_fijado, x0_fijado)

print("Required cutoff for the fixed parameter: ", resultado)
print("Value of the calculated parameter at this cutoff: ", funcion_logistica(resultado, k_calculado, x0_calculado))
