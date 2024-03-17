package reviewPkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class signupTest {
public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new SafariDriver();
		flyAway1 fa = new flyAway1();
		
//		fa.signUp("abcd@okoyv4olgl.com", "abd4cyef");
		
		fa.signIn("test@test", "test");
//		
//		fa.searchFlight("Bangalore", "Hyderabad");
	}
}

class flyAway1 {
	WebDriver driver;
	
	public flyAway1() {
		this.driver = new SafariDriver();
	}
	public boolean signUp(String emailId, String password) throws InterruptedException {
		String URL = "http://localhost:8080/FlyAway/signup";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(URL);
		
		boolean passed = false;
		
		try {
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(emailId);
//			System.out.println("\\u2713 Email Done");
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
//			System.out.println("\\u2713 Password Done");
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys(password);
//			System.out.println("\\u2713 Password Done");
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//html/body/form/table/tbody/tr[4]/td[2]/input")).sendKeys("Name");
//			System.out.println("\\u2713 Name Done");
//			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/button")).click();
//			System.out.println("\\u2713 Click Done");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("/html/body/a[2]")).click();
			
			passed = true;
		} catch(Exception e) {
			System.out.println("*************************"
					+ "\n Error has signup"
					+ "\n Error has occured"
					+ "\n Error has occured"
					+ "\n*************************");
			e.getMessage();
			System.out.println(e.getMessage());
		} finally {
			//driver.close();
			driver.findElement(By.xpath("/html/body/a[2]"));
			Thread.sleep(2000);
		}
		
		
		return passed;
	}
	
	public boolean signIn(String emailId, String password) throws InterruptedException {
		
		boolean passed = false;
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(emailId);
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
//			Thread.sleep(1000);
		
		try {
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/a[1]")).click();
//			Thread.sleep(5000);
			
			passed = true;
		} catch(Exception e) {
			System.out.println("*************************"
					+ "\n Error has signIn"
					+ "\n Error has occured"
					+ "\n Error has occured"
					+ "\n*************************");
			e.getMessage();
			System.out.println(e.getMessage());
		} finally {
			//driver.close();
		}
		
		
		return passed;
	}
	
	public void searchFlight(String origin, String destination) {

		driver.get("http://localhost:8080/FlyAway/home");
		WebElement selwebsource= driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/select"));
		Select selsrc=new Select(selwebsource);
		selsrc.selectByVisibleText(origin);
		
//		sel = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/select")));
//		sel.selectByVisibleText(destination);
		
//		driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[3]/button")).click();
		
		
		
	}
	
}
