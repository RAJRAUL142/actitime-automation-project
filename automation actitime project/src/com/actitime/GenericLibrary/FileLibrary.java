package com.actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
           //for property files
	    String  path = "./testData/commondata.property";
	    public String readDataFromPropertyFile(String key) throws IOException {
	    	FileInputStream fis = new FileInputStream(path);
	    	Properties p = new Properties();
	    	p.load(fis);
	    	String value = p.getProperty(key);
			return value;
	    }

        //for excel file 
       String   path1 = "./testData/automation.xlsx";
       public String readDataFromExcelFile(String sheet, int row, int col) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis = new FileInputStream(path1);
    	Workbook wb = WorkbookFactory.create(fis);
         String data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
         return data;
       }
       
       //for update excel file
       public String setFromExcelFile(String sheet, int row, int col, String setcell) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis = new FileInputStream(path1);
    	Workbook wb = WorkbookFactory.create(fis);
    	wb.getSheet(sheet).getRow(row).getCell(col).setCellValue(setcell);
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
		return setcell;
       }
      
}