package UtilityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {
	XSSFWorkbook workbook;

	public ExcelReader(String path) throws IOException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}

	public int getTotalRowCount(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum() + 1;
	}

	public int getTotalCellCount(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}

	public Object getSpecificSheetData(int sheetIndex, int row, int cell) {

		XSSFCell cells = workbook.getSheetAt(sheetIndex).getRow(row).getCell(cell);
		if (cells == null) {
			return "";
		} else {
			if (cells.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cells.getStringCellValue();
			} else if (cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cells.getRawValue();
			} else if (cells.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cells.getBooleanCellValue();
			} else if (cells.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cells.getCellFormula();
			} else {
				return cells.getErrorCellValue();
			}
		}

	}

	public Object[][] getAllSheetData(int sheetIndex) {
		int rows = getTotalRowCount(sheetIndex);
		int cells = getTotalCellCount(sheetIndex);

		Object[][] data = new Object[rows][cells];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cells; j++) {

				data[i][j] = getSpecificSheetData(sheetIndex, i, j);
			}
		}
		return data;
	}
}
