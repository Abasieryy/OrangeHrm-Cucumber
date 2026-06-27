package tests.Reuse;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelManager {
    private XSSFWorkbook workbook;
    private Sheet sheet;

    public ExcelManager(String filepath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExcelManager(String filepath, int sheetIndex) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(sheetIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public void changeSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    public void changeSheet(int sheetIndex) {
        sheet = workbook.getSheetAt(sheetIndex);
    }
    public String getSpecificCellData(int rowNumber, int columnNumber){
        try{
            Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);
            DataFormatter dataFormatter = new DataFormatter();
            return dataFormatter.formatCellValue(cell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<String[]> getRows() {

        List<String[]> data = new ArrayList<>();
        for (int i = 1; i < getRowCount(); i++) {
            String[] rowData = new String[getColumnCount()];
            for(int j=0; j<rowData.length;j++){
                rowData[j] =getSpecificCellData(i,j);
            }
            data.add(rowData);
        }
        return data;
    }
    public List<String> getHeaderName(){
        List<String> headerName = new ArrayList<>();
        try {
            for (int i=0; i<getColumnCount();i++){
                headerName.add(getSpecificCellData(0,i));
            }
            return headerName;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Map<String,List<String>> getColumnData(){
        HashMap<String, List<String>>   ColumnData = new HashMap<>();
        List<String> headers= getHeaderName();
        for (int i=0;i<getColumnCount();i++){
            List<String> data = new ArrayList<>();
            for (int j=1; j<getRowCount();j++){
                data.add(getSpecificCellData(j,i));
            }
            ColumnData.put(headers.get(i),data);
        }
        return ColumnData;
    }

}
