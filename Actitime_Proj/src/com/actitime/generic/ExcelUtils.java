package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	static final String filePath = ".\\test Data\\testData.xlsx";
	public static String readData(String sheetName,int rowNum,int cellName){
		String data="";
		try{
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
		data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellName).getStringCellValue();
		}
		catch(EncryptedDocumentException e){
			e.printStackTrace();
		}
		catch(InvalidFormatException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
			
		return data;
	}

}
