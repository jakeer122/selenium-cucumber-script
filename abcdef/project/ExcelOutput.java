package project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOutput {
	@Test
	public void dataExport() throws IOException
	{
		FileOutputStream fos=new FileOutputStream("D:\\selenium scripts\\textdata\\data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s=wb.createSheet("Sheet1");
		XSSFSheet s1=wb.createSheet("results");
		XSSFSheet s2=wb.createSheet("jakeer");
		XSSFRow r=s1.createRow(1);
		r.createCell(1).setCellValue("jakeer");
		r.createCell(2).setCellValue("anwar");
		wb.write(fos);
				
		
		
	}
	

}
