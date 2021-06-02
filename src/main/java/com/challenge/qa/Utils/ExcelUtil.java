package com.challenge.qa.Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil
{
    private static FileInputStream file;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;


    public static String getData(String sheetName, int rowNumber, int column) throws IOException {
        file = new FileInputStream("Resources/data.xlsx");
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);

        String data = "";

        try
        {
            data = sheet.getRow(rowNumber).getCell(column).getStringCellValue();
        }catch (Exception e)
        {
            new Throwable("The data is coming empty");
        }
        return data;
    }
}
