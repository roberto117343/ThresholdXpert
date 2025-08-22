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

import static com.RRF.ThresholdXpert.Interfaz.DialogSalida;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida1;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida2;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida3;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida4;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida5;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida6;
import static com.RRF.ThresholdXpert.Interfaz.DialogSalida7;
import static com.RRF.ThresholdXpert.Interfaz.jButton3;
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
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Reinosa Fernández
 */

public class Calcular_Puntos_Corte {
    
    public static void cargarPuntosCorte(String entrada, String valoresBusqueda, String valoresMaximos, int hiloActual){
        
        try{
            
            switch(hiloActual){
            
                case 1:
                    
                    DialogSalida.setLocationRelativeTo(null);
                    break;
                   
                case 2: 
                    
                    DialogSalida1.setLocationRelativeTo(null);
                    break;
                    
                case 3: 
                    
                    DialogSalida2.setLocationRelativeTo(null);
                    break;
                    
                case 4: 
                    
                    DialogSalida3.setLocationRelativeTo(null);
                    break;

                case 5: 
                    
                    DialogSalida4.setLocationRelativeTo(null);
                    break;
                    
                    
                case 6: 
                    
                    DialogSalida5.setLocationRelativeTo(null);
                    break;
                    
                case 7: 
                    
                    DialogSalida6.setLocationRelativeTo(null);
                    break;
                    
                case 8: 
                    
                    DialogSalida7.setLocationRelativeTo(null);
                    break;
                
            }
            
            String salida = "";

            String valoresBusquedaSeparados[] = valoresBusqueda.split(";");
            String valoresMaximosSeparados[] = valoresMaximos.split(";");

            double porcentajePositivos = Double.parseDouble(valoresBusquedaSeparados[0]);
            double porcentajeNegativos = Double.parseDouble(valoresBusquedaSeparados[1]);
            double porcentajeTotales = Double.parseDouble(valoresBusquedaSeparados[2]);

            String entradaCadena = entrada;

            FileReader f = new FileReader(entradaCadena);
            BufferedReader b = new BufferedReader(f);

            String linea;

            linea = b.readLine();

            f.close();
            b.close();

            int columnas = 0;

            for(int i = 0; i < linea.length(); i++) {

                if (Thread.currentThread().isInterrupted()) {

                    break;

                }
                
                if(linea.toCharArray()[i] == ';') {

                    columnas++;

                }

            }

            columnas++;

            String valores[];

            double minimo = 0.0;

            Random random = new Random();

            ArrayList<Double> cortes;

            double valoresMaximosNumerico[] = new double[valoresMaximosSeparados.length];

            for(int i = 0; i < valoresMaximosNumerico.length; i++){

                if (Thread.currentThread().isInterrupted()) {

                    break;

                }
                
                valoresMaximosNumerico[i] = Double.parseDouble(valoresMaximosSeparados[i]);

            }

            int aciertosPositivos;
            int fallosPositivos;
            int aciertosNegativos;
            int fallosNegativos;
            int contadorTotales;
            int contadorPositivos;
            int contadorNegativos;

            double frecuenciaAciertosPositivos;
            double frecuenciaAciertosNegativos;
            double frecuenciaAciertosTotales;

            boolean positividad;

            salida += "RESULTS:";

            switch(hiloActual){
            
                case 1:
                    
                    DialogSalida.setVisible(true);
                    jTextArea1.setText(salida);
                    break;
                   
                case 2: 
                    
                    DialogSalida1.setVisible(true);
                    jTextArea2.setText(salida);
                    break;
                    
                case 3: 
                    
                    DialogSalida2.setVisible(true);
                    jTextArea3.setText(salida);
                    break;
                    
                case 4: 
                    
                    DialogSalida3.setVisible(true);
                    jTextArea4.setText(salida);
                    break;
                    
                case 5: 
                    
                    DialogSalida4.setVisible(true);
                    jTextArea5.setText(salida);
                    break;
                    
                case 6: 
                    
                    DialogSalida5.setVisible(true);
                    jTextArea6.setText(salida);
                    break;
                    
                case 7: 
                    
                    DialogSalida6.setVisible(true);
                    jTextArea7.setText(salida);
                    break;
                    
                case 8: 
                    
                    DialogSalida7.setVisible(true);
                    jTextArea8.setText(salida);
                    break;
                
            
            }
            
            for(int k = 0; k < 1000000000; k++) {

                if (Thread.currentThread().isInterrupted()) {

                    break;

                }
                
                f = new FileReader(entradaCadena);
                b = new BufferedReader(f);

                cortes = new ArrayList<>();

                for(int i = 0; i < columnas-1; i++) {

                    if (Thread.currentThread().isInterrupted()) {

                        break;

                    }
                    
                    cortes.add(minimo + (valoresMaximosNumerico[i] - minimo) * random.nextDouble());

                }

                aciertosPositivos = 0;
                fallosPositivos = 0;
                aciertosNegativos = 0;
                fallosNegativos = 0;
                contadorTotales = 0;
                contadorPositivos = 0;
                contadorNegativos = 0;

                while((linea = b.readLine()) != null) {

                    if (Thread.currentThread().isInterrupted()) {

                        break;

                    }
                    
                    valores = linea.split(";");

                    positividad = false;

                    for(int i = 0; i < valores.length-1; i++) {

                        if (Thread.currentThread().isInterrupted()) {

                            break;

                        }
                        
                        if(Double.parseDouble(valores[i]) >= cortes.get(i)) {

                            positividad = true;
                            break;

                        }

                    }

                    if(positividad == true && valores[valores.length-1].equals("1")) {

                        aciertosPositivos++;
                        contadorPositivos++;

                    }else if(positividad == true && valores[valores.length-1].equals("0")) {

                        fallosPositivos++;
                        contadorNegativos++;

                    }else if(positividad == false && valores[valores.length-1].equals("0")) {

                        aciertosNegativos++;
                        contadorNegativos++;

                    }else if(positividad == false && valores[valores.length-1].equals("1")) {

                        fallosNegativos++;
                        contadorPositivos++;

                    }

                    contadorTotales++;

                }

                frecuenciaAciertosPositivos = (double)aciertosPositivos/contadorPositivos;
                frecuenciaAciertosNegativos = (double)aciertosNegativos/contadorNegativos;
                frecuenciaAciertosTotales = (double)(aciertosPositivos + aciertosNegativos)/contadorTotales;

                if(frecuenciaAciertosPositivos >= porcentajePositivos && frecuenciaAciertosNegativos >= porcentajeNegativos && frecuenciaAciertosTotales >= porcentajeTotales) {

                    salida += "\nPositive Fit: " + frecuenciaAciertosPositivos + "\nNegative Fit: " + frecuenciaAciertosNegativos + "\nTotal Fit: " + frecuenciaAciertosTotales + "\n";

                    salida += ("Thresholds\n");

                    for(int i = 0; i < cortes.size(); i++) {

                        salida += cortes.get(i) + "     ";

                    }

                    salida += "\n------------------------------------------------------------------------------------";

                    if (!Thread.currentThread().isInterrupted()) {
                    
                        switch(hiloActual){

                            case 1:

                                DialogSalida.setVisible(true);
                                jTextArea1.setText(salida);
                                break;

                            case 2: 

                                DialogSalida1.setVisible(true);
                                jTextArea2.setText(salida);
                                break;

                            case 3: 

                                DialogSalida2.setVisible(true);
                                jTextArea3.setText(salida);
                                break;

                            case 4: 

                                DialogSalida3.setVisible(true);
                                jTextArea4.setText(salida);
                                break;

                            case 5: 

                                DialogSalida4.setVisible(true);
                                jTextArea5.setText(salida);
                                break;


                            case 6: 

                                DialogSalida5.setVisible(true);
                                jTextArea6.setText(salida);
                                break;

                            case 7: 

                                DialogSalida6.setVisible(true);
                                jTextArea7.setText(salida);
                                break;

                            case 8: 

                                DialogSalida7.setVisible(true);
                                jTextArea8.setText(salida);
                                break;


                        }
                    
                    }

                }

                f.close();
                b.close();

            }
        
        }catch(Exception e){
            
            Logger.getLogger(Calcular_Puntos_Corte.class.getName()).log(Level.SEVERE, null, e);
            
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
