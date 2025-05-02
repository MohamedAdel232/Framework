package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static final String ExcelFilePath = "src/test/resources/TestData/";

    public static String readDataFromExcelSheet(String fileName, int sheetIndex, int rowIndex, int cellIndex) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(ExcelFilePath + fileName + ".xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(cellIndex);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            LogsUtils.error("Error reading the file: " + e.getMessage());
            return null;
        }
    }

    public static List<List<String>> readAllDataFromExcelSheet(String fileName, int sheetIndex) {
        FileInputStream fileInputStream;
        List<List<String>> data = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(ExcelFilePath + fileName + ".xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            DataFormatter formatter = new DataFormatter();

            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(formatter.formatCellValue(cell));
                }
                data.add(rowData);
            }
        } catch (Exception e) {
            LogsUtils.error("Error reading the file: " + e.getMessage());
        }
        return data;
    }

    public static List<List<String>> readRowDataFromExcelSheet(String fileName, int sheetIndex, int rowIndex) {
        FileInputStream fileInputStream;
        List<List<String>> data = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(ExcelFilePath + fileName + ".xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            DataFormatter formatter = new DataFormatter();
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(formatter.formatCellValue(cell));
            }
            data.add(rowData);
        } catch (Exception e) {
            LogsUtils.error("Error reading the file: " + e.getMessage());
        }
        return data;
    }
}
