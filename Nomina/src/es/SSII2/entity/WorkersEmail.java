/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.SSII2.entity;

import java.util.ArrayList;
import es.SSII2.entity.WorkersID;
import java.util.Collections;
/**
 *
 * @author Alvaro
 */
public class WorkersEmail {
    ArrayList<WorkersID> arrayWorkers;
    ArrayList<String> arrayCorreos = new ArrayList<>();
    
    
    public WorkersEmail(ArrayList<WorkersID> trabajador) {
        this.arrayWorkers = trabajador;
    }
    
    public void creacionCorreos(){
        
        for(int i=0; i<arrayWorkers.size();i++){
            String nombre = arrayWorkers.get(i).getNombre();
            String apellido1 = arrayWorkers.get(i).getApellido1();
            String apellido2 = arrayWorkers.get(i).getApellido2();
            String empresa = arrayWorkers.get(i).getEmpresa();
            
            String iniNombre= quitarAcentos(nombre.substring(0,2)).toLowerCase();
            String iniApe1= quitarAcentos(apellido1.substring(0,2)).toLowerCase();
            String iniApe2= quitarAcentos(apellido2.substring(0,2)).toLowerCase();
            
            String empresaN = empresa.replace(" ", "");
            empresaN = empresaN.replace(".", "").toLowerCase();
            
            String nombreCorreo = iniNombre+iniApe1+iniApe2;
            
            int numCasos = Collections.frequency(arrayCorreos, nombreCorreo);
            
            arrayCorreos.add(nombreCorreo);
            
            String num="";
            
            if(numCasos<9)
                num = "0" + Integer.toString(numCasos);
            
            String correo = iniNombre+iniApe1+iniApe2+ num +"@"+empresaN+".es";
          
             arrayWorkers.get(i).setEmail(correo);
             
            System.out.println(arrayWorkers.get(i).getEmail());
           
            
            
            
        }
        
       
    }
    public String quitarAcentos(String aaa){
            // Cadena de caracteres original a sustituir.
        String original = "áàäéèëíìïóòöúùuÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String ascii = "aaaeeeiiiooouuuAAAEEEIIIOOOUUUNcC";
        String output = aaa;
        for (int i=0; i<original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }
}
