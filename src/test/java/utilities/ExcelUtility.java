package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;

    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get number of rows
    public int getRowCount(String sheetName) throws IOException {

        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        int rowcount = sheet.getLastRowNum();

        workbook.close();
        fi.close();

        return rowcount;
    }

    // Get number of cells in a particular row
    public int getCellCount(String sheetName, int rownum) throws IOException {

        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);

        int cellcount = row.getLastCellNum();

        workbook.close();
        fi.close();

        return cellcount;
    }

    // Get data from a particular cell
    public String getCellData(
            String sheetName,
            int rownum,
            int column) throws IOException {

        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);

        cell = row.getCell(column);

        DataFormatter formatter = new DataFormatter();

        String data;

        try {

            data = formatter.formatCellValue(cell);

        } catch (Exception e) {

            data = "";

        }

        workbook.close();
        fi.close();

        return data;
    }

    // Set data into Excel cell
    public void setCellData(
            String sheetName,
            int rownum,
            int column,
            String data) throws IOException {

        File file = new File(path);

        // If Excel file does not exist, create it
        if (!file.exists()) {

            workbook = new XSSFWorkbook();

            fo = new FileOutputStream(path);

            workbook.write(fo);

            workbook.close();
            fo.close();
        }

        // Open Excel file
        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        // If sheet does not exist, create new sheet
        if (workbook.getSheetIndex(sheetName) == -1) {

            workbook.createSheet(sheetName);
        }

        sheet = workbook.getSheet(sheetName);

        // If row does not exist, create new row
        if (sheet.getRow(rownum) == null) {

            sheet.createRow(rownum);
        }

        row = sheet.getRow(rownum);

        // Create cell
        cell = row.createCell(column);

        // Set value
        cell.setCellValue(data);

        // Write changes
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill cell with GREEN color
    public void fillGreenColor(
            String sheetName,
            int rownum,
            int column) throws IOException {

        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);

        cell = row.getCell(column);

        org.apache.poi.ss.usermodel.CellStyle style =
                workbook.createCellStyle();

        style.setFillForegroundColor(
                IndexedColors.GREEN.getIndex());

        style.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        // IMPORTANT: create output stream before write
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }

    // Fill cell with RED color
    public void fillRedColor(
            String sheetName,
            int rownum,
            int column) throws IOException {

        fi = new FileInputStream(path);

        workbook = new XSSFWorkbook(fi);

        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rownum);

        cell = row.getCell(column);

        org.apache.poi.ss.usermodel.CellStyle style =
                workbook.createCellStyle();

        style.setFillForegroundColor(
                IndexedColors.RED.getIndex());

        style.setFillPattern(
                FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        // IMPORTANT: create output stream before write
        fo = new FileOutputStream(path);

        workbook.write(fo);

        workbook.close();
        fi.close();
        fo.close();
    }
}