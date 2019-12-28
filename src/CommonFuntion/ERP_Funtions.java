package CommonFuntion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Funtions {
	
	WebDriver driver;
	String res;
	public String LanchBrowser(String URL){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\naveen\\Desktop\\Naveen\\LiveProject\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
			res="Pass";
		}else{
			res="Fail";
		}
		
	return res;
	
	}	
	public String Login(String username,String password ) throws Exception{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnsubmit")).click();
		Thread.sleep(3000);
		
		
		if(driver.findElement(By.xpath("//*[@id='mi_logout']")).isDisplayed()){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
	}
	public String Supplier(String sname,String address,String city,String country,
			String cperson,String pnumber,String mail,String mnumber,String note ){
		
		driver.findElement(By.xpath("//*[@id='mi_a_suppliers']/a")).click();
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		String expdata=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
		driver.findElement(By.id("x_Address")).sendKeys(address);
		driver.findElement(By.id("x_City")).sendKeys(city);
		driver.findElement(By.id("x_Country")).sendKeys(country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
		driver.findElement(By.id("x__Email")).sendKeys(mail);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
		driver.findElement(By.id("x_Notes")).sendKeys(note);
		
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		//button[contains(text(),'OK!']
		if(driver.findElement(By.id("psearch")).isDisplayed()){
			res="Pass";
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
			String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
			if(expdata.equalsIgnoreCase(actdata)){
				res="Pass";
				
			}
		}else{
			res="Fail";
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.id("btnsubmit")).click();
			String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
			if(expdata.equalsIgnoreCase(actdata)){
				res="Pass";
				
			}else{
				res="Fail";
		}
		}
		return res;
		
	}
	
	public String Logout(){
		
		driver.findElement(By.id("logout")).click();
		if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
			res="Pass";
		}else{
			res="Fail";
		}
		return res;
		
	}

}
