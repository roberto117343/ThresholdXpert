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

import static com.RRF.ThresholdXpert.Interfaz.DialogSalida;
import static com.RRF.ThresholdXpert.Interfaz.jButton3;
import static com.RRF.ThresholdXpert.Interfaz.jLabel5;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea1;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea2;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea3;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea4;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea5;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea6;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea7;
import static com.RRF.ThresholdXpert.Interfaz.jTextArea8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Predictor_Puntos_Corte {

    public static void cargarPredictorPuntosCorte(int seleccion, String entrada, String valores, String puntosCorte) {
		
        if(seleccion == 1){
            
            jLabel5.setText("Prediction values: " + prediccionIndividual(valores, puntosCorte));
            jButton3.setEnabled(true);
            
        }else if(seleccion == 2){
            
            DialogSalida.setLocationRelativeTo(null);
            prediccionArchivo(entrada, puntosCorte);
            jButton3.setEnabled(true);
            
        }
        
    }
	
    public static String prediccionIndividual(String valores, String puntosCorte) {
        
        try{
        
            String valoresSeparados[] = valores.split(";");
            String puntosCorteSeparados[] = puntosCorte.split(";");

            boolean positividad = false;

            for(int i = 0; i < puntosCorteSeparados.length; i++) {

                if (Thread.currentThread().isInterrupted()) {

                    break;

                }
                
                positividad = false;

                if(Double.parseDouble(valoresSeparados[i]) >= Double.parseDouble(puntosCorteSeparados[i])) {

                    positividad = true;
                    break;

                }

            }

            if(positividad) {

                return "POSITIVE";

            }else {

                return "NEGATIVE";

            }
	
        }catch(Exception e){
            
            Logger.getLogger(Predictor_Puntos_Corte.class.getName()).log(Level.SEVERE, null, e);
            
            DialogSalida.setLocationRelativeTo(null);
            DialogSalida.setVisible(true);
            jTextArea1.setText("ERROR");
            jTextArea2.setText("ERROR");
            jTextArea3.setText("ERROR");
            jTextArea4.setText("ERROR");
            jTextArea5.setText("ERROR");
            jTextArea6.setText("ERROR");
            jTextArea7.setText("ERROR");
            jTextArea8.setText("ERROR");
            jButton3.setEnabled(true);
            
            Cancelar_Hilos.cargarCancelarHilos();
            
            return "";
            
        }
        
    }
	
    public static void prediccionArchivo(String entrada, String puntosCorte) {
		
        try{
        
            FileReader f = new FileReader(entrada);
            BufferedReader b = new BufferedReader(f);

            String linea;
            String salida = "";

            DialogSalida.setVisible(true);

            while((linea = b.readLine()) != null) {

                if (Thread.currentThread().isInterrupted()) {

                    break;

                }
                
                salida += linea + ";" + prediccionIndividual(linea, puntosCorte) + "\r\n";

            }

            jTextArea1.setText(salida);
        
        }catch(Exception e){
            
            Logger.getLogger(Predictor_Puntos_Corte.class.getName()).log(Level.SEVERE, null, e);
                        
            DialogSalida.setLocationRelativeTo(null);
            DialogSalida.setVisible(true);
            jTextArea1.setText("ERROR");
            jTextArea2.setText("ERROR");
            jTextArea3.setText("ERROR");
            jTextArea4.setText("ERROR");
            jTextArea5.setText("ERROR");
            jTextArea6.setText("ERROR");
            jTextArea7.setText("ERROR");
            jTextArea8.setText("ERROR");
            jButton3.setEnabled(true);
            
            Cancelar_Hilos.cargarCancelarHilos();
            
        }
        
    }

}