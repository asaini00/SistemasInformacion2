/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.SSII2.Main;

import es.SSII2.manager.*;
import es.SSII2.entity.*;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Windows
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
 
        
      /**
       * Practica 1
       */ 
        //creamos un nuevo objeto para calcular el dni
       // WorkersDni dni = new WorkersDni();
        
        //pasamos la ruta del excel y el objeto dni
       // ExcelManagerDni excel = new ExcelManagerDni("src/es/SSII2/resources/Practica1.xlsx",dni);
        
        //se lee el dni
       // excel.LeerExcelDni();
        
        //se calcula la letra
       // dni.calculatorLetterDni();
        //dni.imprimir();
        
        //actualziar dnis del excel
        //excel.actualizarDnis(dni.getDnis(), dni.getDnisCalculados(), dni.getDnisPos());
        
      /**
       * Practica2
       */  
    
      WorkersBank account = new WorkersBank();
      
      ExcelManagerAccount excelAccount = new ExcelManagerAccount("src/es/SSII2/resources/Practica2.xlsx",account);
    
      excelAccount.readAccountExcel();
        
      account.calculoDigitoControl();
      
      //account.print();
      
      //System.out.println();
      
      excelAccount.actualizarCuentas(account.getAccounts(), 
                                     account.getNewsAccounts(), 
                                     account.getArrayIban(),
                                     account.getAccountsPossitions());

      System.out.println("Prueba push");
      
    }
    
    
}
