package com.pulselms.app.framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.testng.annotations.DataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;

public class DataProviderClass {
	protected static final Logger log = Logger.getLogger(DataProviderClass.class);

	/**
	 * @param data_Folder
	 * @param data_File_Name
	 * @param Sheet_Name
	 * @param St_Val
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "DP_JXL")
	public static Object[][] data_provider(Method testMethod) {
		// String[][] tabArray=null;
		Object[][] objectArray = null;
		DataProviderArguments args = testMethod.getAnnotation(DataProviderArguments.class);

		if (args == null)
			throw new IllegalArgumentException("Test Method context has no DataProviderArguments annotation.");
		if (args.data_File_Name() == null || args.data_File_Name().trim().equalsIgnoreCase(""))
			throw new IllegalArgumentException(
					"Test Method context has a malformed DataProviderArguments annotation.[data_File_Name is missing or empty]");
		if (args.sheetname() == null || args.sheetname().trim().equalsIgnoreCase(""))
			throw new IllegalArgumentException(
					"Test Method context has a malformed DataProviderArguments annotation.[sheetname is missing or empty]");
		if (args.tablename() == null || args.tablename().trim().equalsIgnoreCase(""))
			throw new IllegalArgumentException(
					"Test Method context has a malformed DataProviderArguments annotation.[tablename is missing or empty]");

		String data_Folder = args.data_Folder();
		String data_File_Name = args.data_File_Name();
		String Sheet_Name = args.sheetname();
		String St_Val = args.tablename();

		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File(data_Folder + File.separator + data_File_Name));
		} catch (BiffException | IOException e) {
			throw new IllegalArgumentException(
					"Error Reading data_file_name:" + data_File_Name + " -> " + e.getLocalizedMessage());
		}
		Sheet sheet = workbook.getSheet(Sheet_Name);
		if (sheet == null)
			throw new IllegalArgumentException("Sheet name specified:" + Sheet_Name + " is not available");

		int startRow, startCol, endRow, endCol, ci;
		// int cj;
		Cell tableStart = sheet.findCell(St_Val);

		if (tableStart == null)
			throw new IllegalArgumentException("table name specified:" + St_Val + " is not available");
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(St_Val, startCol + 1, startRow + 1, sheet.getColumns(), sheet.getRows(), false);
		if (tableEnd == null)
			throw new IllegalArgumentException("table name specified:" + St_Val + " is not available");

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println(
				"startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol + ", endCol=" + endCol);
		// tabArray=new String[endRow-startRow-1][endCol-startCol-1];
		// tabArray=new String[endRow-startRow][endCol-startCol-1];
		objectArray = new Object[endRow - startRow - 1][1];
		/*
		 * ci=0; for (int i=startRow+1;i<endRow;i++,ci++){ cj=0; for (int
		 * j=startCol+1;j<endCol;j++,cj++){
		 * tabArray[ci][cj]=sheet.getCell(j,i).getContents(); } }
		 */
		ci = 1;
		for (int i = startRow + 1; i < endRow; i++, ci++) {
			Map<String, String> rowdata = new HashMap<String, String>();
			for (int j = startCol + 1; j < endCol; j++) {
				// rowdata.put(tabArray[0][cj], tabArray[ci][cj]);
				rowdata.put(sheet.getCell(j, startRow).getContents(), sheet.getCell(j, i).getContents());
			}
			objectArray[ci - 1] = new Object[] { rowdata };
		}
		// return(tabArray);
		return objectArray;
	}

	@DataProvider(name = "DP_POI")
	public static Object[][] getData(Method testMethod) {
		


		Xls_Reader datatable = null;
		Hashtable<String, String> table = null;
		DataProviderArguments args = testMethod.getAnnotation(DataProviderArguments.class);

		String data_Folder = args.data_Folder();
		String data_File_Name = args.data_File_Name();
		String Sheet_Name = args.sheetname();

		datatable = new Xls_Reader(data_Folder + File.separator + data_File_Name);

		int rows = datatable.getRowCount(Sheet_Name) - 1;
		if (rows <= 0) {
			Object[][] testData = new Object[1][0];
			return testData;
		}
		rows = datatable.getRowCount(Sheet_Name) - 1; // 3
		int cols = datatable.getColumnCount(Sheet_Name);
		log.info("Rows  "+rows);
	       log.info("Cols  "+cols);
		Object data[][] = new Object[rows][1];
		for (int rowNum = 2; rowNum < rows + 2; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(datatable.getCellData(Sheet_Name, colNum, 1),
						datatable.getCellData(Sheet_Name, colNum, rowNum));
			}
			data[rowNum - 2][0] = table;
		}
		return data;
	}

}
