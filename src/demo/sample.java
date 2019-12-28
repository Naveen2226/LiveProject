package demo;

public class sample {

	public static void main(String[] args) throws Exception {
		
		ExcelFileUtil efu=new ExcelFileUtil();
		
		
		int rowCount= efu.rowCount("Supplier");
		System.out.println(rowCount);
		
        int colCount= efu.colCount("Supplier");
	    System.out.println(colCount);
		
		String getData =efu.getData("Supplier", 1, 1);
		System.out.println(getData);
		
		//void setData=efu.setData("Supplier", 1, 10,"Pass");
}
}