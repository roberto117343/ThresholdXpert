/**
 * «Copyright 2025 Roberto Reinosa»
 * 
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * */

package com.RRF.ThresholdXpert;

/**
 *
 * @author Roberto Reinosa Fernández
 */

public class Hilo_Calcular_Puntos_Corte7 implements Runnable{
    
    public static Thread t_calcular_puntos_corte7;
    
    public String entrada;
    public String valoresBusqueda;
    public String valoresMaximos;
    
    public Hilo_Calcular_Puntos_Corte7(String entrada, String valoresBusqueda, String valoresMaximos){
        
        this.entrada = entrada;
        this.valoresBusqueda = valoresBusqueda;
        this.valoresMaximos = valoresMaximos;
        
        t_calcular_puntos_corte7 = new Thread(this, "Hilo_Calcular_Puntos_Corte7");
        t_calcular_puntos_corte7.start();
        
    }
    
    @Override
    public void run(){
        
        Calcular_Puntos_Corte.cargarPuntosCorte(entrada, valoresBusqueda, valoresMaximos, 7);
        
    }
    
}
