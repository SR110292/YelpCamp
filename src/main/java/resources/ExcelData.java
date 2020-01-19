package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String[][] readExcel(String sheetname) throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Selenium codes\\Full framework\\ZZZproject\\src\\main\\java\\resources\\Datasheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheet(sheetname);
		int row = worksheet.getLastRowNum();
		int column = worksheet.getRow(0).getLastCellNum();
		String[][] data = new String[row][column-1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j < column; j++) {
				XSSFCell cell = worksheet.getRow(i).getCell(j);
				data[i - 1][j-1] = cell.getStringCellValue();
			}
		}
		return data;
	}
}
