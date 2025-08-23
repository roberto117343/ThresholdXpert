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


def optimo(k1, x01, k2, x02):

    resultado = ((k1 * x01) - (k2 * x02))/(k1 - k2)
    return resultado


k1 = float(input("Enter k_sens: "))
x01 = float(input("Enter x0_sens: "))

k2 = float(input("Enter k_spe: "))
x02 = float(input("Enter x0_spe: "))

print("Optimal point: ", optimo(k1, x01, k2, x02))
