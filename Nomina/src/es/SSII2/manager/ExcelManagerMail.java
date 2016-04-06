/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.SSII2.manager;
import es.SSII2.entity.WorkersID;
import es.SSII2.entity.WorkersEmail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Alvaro
 */
public class ExcelManagerMail {

    WorkersID workers;
    WorkersEmail email;
    String excel;
    ArrayList<WorkersID> arrayWorkers= new ArrayList<WorkersID>();
    
    public ExcelManagerMail(String excel) {
        this.excel = excel;
    }

 public void readAccountExcel() throws FileNotFoundException, IOException{
    
        FileInputStream file;
        file = new FileInputStream(new File(excel));

        try ( 
            XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            // Recorremos todas las filas para mostrar el contenido de cada celda
            while (rowIterator.hasNext()) {
                
                workers = new WorkersID();
                row = rowIterator.next();
                
                // Obtenemos el iterator que permite recorres todas las celdas de una fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell celda;
                
                
                String celdas;

                while (cellIterator.hasNext()){
                    
                   
                    celda = cellIterator.next();
                    
                   if(celda.getRowIndex() >= 1 && celda.getColumnIndex() == 0 && celda.getCellType() != 3){
                    
                      celdas = celda.getStringCellValue();
                      
                      //anadir la cuenta al arraylist y las posiciones
                     workers.setNombre(celdas);
                     
                     
                   }

                   if(celda.getRowIndex() >= 1 && celda.getColumnIndex() == 1 && celda.getCellType() != 3){
                    
                      celdas = celda.getStringCellValue();
                      
                      //anadir la cuenta al arraylist y las posiciones
                     workers.setApellido1(celdas);
                    
                   }if(celda.getRowIndex() >= 1 && celda.getColumnIndex() == 2 && celda.getCellType() != 3){
                    
                      celdas = celda.getStringCellValue();
                      
                      //anadir la cuenta al arraylist y las posiciones
                     workers.setApellido2(celdas);
                     
                     
                   }
                   if(celda.getRowIndex() >= 1 && celda.getColumnIndex() == 6 && celda.getCellType() != 3){
                    
                      celdas = celda.getStringCellValue();
                      
                      //anadir la cuenta al arraylist y las posiciones
                     workers.setEmpresa(celdas);
                     
                     
                   }
                }
              
                //se mete los datos en el arraylist 
                if(workers.getNombre()!=null)
                    arrayWorkers.add(workers);
            }
            
        }
        
        //System.out.println(arrayWorkers.get(6).getApellido1());
         email = new WorkersEmail(arrayWorkers);
         email.creacionCorreos();
    }
    public void actualizarDnis() throws IOException {
          
            int row;
            int col=15;
 
            FileInputStream file;
            file = new FileInputStream(new File(excel));  
              
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            
                for (int i = 0; i < arrayWorkers.size(); i++) {
                    
                    row=i;
                    XSSFRow rowEmail = sheet.getRow(row+1); //coje la fila
                    XSSFCell cellEmail = rowEmail.createCell(col); //crea la celda
                    cellEmail.setCellValue(arrayWorkers.get(i).getEmail());
                
                    //escribe en el excel
                    try (FileOutputStream outFile = new FileOutputStream(new File(excel))) {
                        workbook.write(outFile);

                      
                    }
                
            }//for
    }
}
