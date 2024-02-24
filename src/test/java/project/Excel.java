package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public void excelsheet(String alert1,String alert2,String title) {
	try {
		File file2 =new File(System.getProperty("user.dir")+"\\outputdata\\outputdata1.xlsx");
        FileOutputStream file = new FileOutputStream(file2);
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet();
        XSSFRow r1 = sheet.createRow(0);
        XSSFRow r2 = sheet.createRow(1);
        r1.createCell(1).setCellValue("First Alert Text");
        r1.createCell(2).setCellValue("Second Alert Text");
        r1.createCell(3).setCellValue("The New Tab Title");
        
        r2.createCell(1).setCellValue(alert1);
        r2.createCell(2).setCellValue(alert2);
        r2.createCell(3).setCellValue(title);
        
        System.out.println("data entered into excel");
        workbook.write(file);
        workbook.close();
        file.close();
      } 
		catch (IOException e) {
			
      }
	}
}
