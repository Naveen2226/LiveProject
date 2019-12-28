package demo;

import CommonFuntion.ERP_Funtions;

public class RunSuppliers {
	public static void main(String[] args) throws Exception {	
		ExcelFileUtil efu=new ExcelFileUtil();
		int rowcount=efu.rowCount("Supplier");
		for(int i=1;i<=rowcount; i++){
			String sname=efu.getData("Supplier", i, 0);
			String address=efu.getData("Supplier", i, 1);
			String city=efu.getData("Supplier", i, 2);
			String country=efu.getData("Supplier", i, 3);
			String cperson=efu.getData("Supplier", i, 4);
			String pnumber=efu.getData("Supplier", i, 5);
			String mail=efu.getData("Supplier", i, 6);
			String mnumber=efu.getData("Supplier", i, 7);
			String note=efu.getData("Supplier", i, 8);
			
			
			
			
			ERP_Funtions erp= new ERP_Funtions();
			String res=erp.LanchBrowser("http://webapp.qedge.com/login.php");
			String Log=erp.Login("admin", "master");
			String supp=erp.Supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			
		}
		
			
				}
}
