/**
 * «Copyright 2025 Roberto Reinosa Fernández»
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

public class Cancelar_Hilos {
    
    public static void cargarCancelarHilos(){
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte.t_calcular_puntos_corte.isAlive()){
            
                Hilo_Calcular_Puntos_Corte.t_calcular_puntos_corte.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte2.t_calcular_puntos_corte2.isAlive()){
            
                Hilo_Calcular_Puntos_Corte2.t_calcular_puntos_corte2.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte3.t_calcular_puntos_corte3.isAlive()){
            
                Hilo_Calcular_Puntos_Corte3.t_calcular_puntos_corte3.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte4.t_calcular_puntos_corte4.isAlive()){
            
                Hilo_Calcular_Puntos_Corte4.t_calcular_puntos_corte4.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte5.t_calcular_puntos_corte5.isAlive()){
            
                Hilo_Calcular_Puntos_Corte5.t_calcular_puntos_corte5.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte6.t_calcular_puntos_corte6.isAlive()){
            
                Hilo_Calcular_Puntos_Corte6.t_calcular_puntos_corte6.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte7.t_calcular_puntos_corte7.isAlive()){
            
                Hilo_Calcular_Puntos_Corte7.t_calcular_puntos_corte7.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Calcular_Puntos_Corte8.t_calcular_puntos_corte8.isAlive()){
            
                Hilo_Calcular_Puntos_Corte8.t_calcular_puntos_corte8.interrupt();
            
            }
            
        }catch(Exception e){}
        
        try{
           
            if(Hilo_Predictor_Puntos_Corte.t_predictor_puntos_corte.isAlive()){
            
                Hilo_Predictor_Puntos_Corte.t_predictor_puntos_corte.interrupt();
            
            }
            
        }catch(Exception e){}
        
    }
    
}
