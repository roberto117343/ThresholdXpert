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

public class Hilo_Predictor_Puntos_Corte implements Runnable{
    
    public static Thread t_predictor_puntos_corte;
    
    public int selector;
    public String entrada;
    public String valores;
    public String puntosCorte;
    
    public Hilo_Predictor_Puntos_Corte(int selector, String entrada, String valores, String puntosCorte){
        
        this.selector = selector;
        this.entrada = entrada;
        this.valores = valores;
        this.puntosCorte = puntosCorte;
        
        t_predictor_puntos_corte = new Thread(this, "Hilo_Predictor_Puntos_Corte");
        t_predictor_puntos_corte.start();
        
    }
    
    @Override
    public void run(){
        
        Predictor_Puntos_Corte.cargarPredictorPuntosCorte(this.selector, this.entrada, this.valores, this.puntosCorte);
        
    }
    
}
