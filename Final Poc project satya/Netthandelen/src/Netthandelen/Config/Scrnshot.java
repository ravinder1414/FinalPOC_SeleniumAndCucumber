package Netthandelen.Config;

import Netthandelen.Utility.ExcelUtils;

public class Scrnshot {
	
	public static String takeScreen(int row,int column,String Sheet){
		
		 String pngname="";
			try {
			
				pngname = ExcelUtils.getCellData(row,column,Sheet);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return pngname;
	}

}
