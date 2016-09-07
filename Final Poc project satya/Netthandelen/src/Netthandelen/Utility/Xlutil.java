package Netthandelen.Utility;



import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlutil {

	
		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		
		public  List getRowContains(String Path,String SheetName)  {
			List al = new ArrayList();
			try{
			int i;
			//FileInputStream ExcelFile = new FileInputStream(Path);
			FileInputStream ExcelFile = new FileInputStream(new File(Path));
			System.out.println("file:"+ExcelFile);
			
	        ExcelWBook = new XSSFWorkbook(ExcelFile); 
	       // XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
	        System.out.println("wbook:"+ExcelWBook);
	         
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			System.out.println("sheet:"+ExcelWSheet);
			
			ArrayList alrow=null;
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int number = ExcelWSheet.getPhysicalNumberOfRows() ;
			for (i = 0; i < number; i++) {
				if(i>0){
					alrow = new ArrayList();
					for(int j=0;j<5;j++)  ///make it dynamic
					{
						Cell = ExcelWSheet.getRow(i).getCell(j);
						alrow.add(checkNull(Cell));
					}
					
					al.add(alrow);
				}
			}
			System.out.println("here"+al);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return al;
			
		}
		
		public String checkNull(Object o)
		{
			if(o==null) return ""; else return String.valueOf(o);
		}
		
		
	}


