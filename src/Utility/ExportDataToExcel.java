package Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Row;

public class ExportDataToExcel {
	@SuppressWarnings("unused")
	public static void writeToExcell(JTable table, String string) throws FileNotFoundException, IOException {
	    new XSSFWorkbookFactory();
	    Workbook wb = new XSSFWorkbook(); //Excell workbook
	    Sheet sheet = wb.createSheet(); //WorkSheet
	    Row row = (Row) sheet.createRow(2); //Row created at line 3
	    TableModel model = table.getModel(); //Table model

	    Row headerRow = (Row) sheet.createRow(0); //Create row at line 0
	    for(int headings = 0; headings < model.getColumnCount()-1; headings++){ 
	    	
	    	//For each column
	        (headerRow).createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
	    }

	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
	        for(int cols = 0; cols < table.getColumnCount()-1; cols++){ //For each table column
	            row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	        }

	        //Set the row to the next one in the sequence 
	        row = sheet.createRow((rows + 3)); 
	    }
	    wb.write(new FileOutputStream("C:\\Users\\User\\Desktop\\image\\test3.xlsx")); 
	   // wb.write(new FileOutputStream(path.toString()));//Save the file     
	}
}