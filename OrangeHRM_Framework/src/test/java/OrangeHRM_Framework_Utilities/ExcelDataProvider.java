package OrangeHRM_Framework_Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	static XSSFWorkbook workbook;
	
	public ExcelDataProvider(String filePath) {

		try {
			FileInputStream	fins = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fins);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getRowCount(String sheetname) {
		return workbook.getSheet(sheetname).getLastRowNum();
	}
	
	public static int getColumnCount(String sheetname) {
		return workbook.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	
	public static String getStringCellData(String sheetname, int row, int col) {
		return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public static Object[][] getExcelData(String sheetname) {
		
		int row = getRowCount(sheetname);
		int col = getColumnCount(sheetname);
		
		System.out.println(row);
		System.out.println(col);
		
		Object[][] data = new Object[row][col];
		
		for(int i=0; i<row; i++) {
			
			for(int j=0; j<col; j++) {
				
				data[i][j] = workbook.getSheet(sheetname).getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}