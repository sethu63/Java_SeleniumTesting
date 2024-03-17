package reviewPkg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class flyAway {
	WebDriver driver;
	
	public flyAway(WebDriver driver) {
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		this.driver = driver;
	}
	
	void register() {
		driver.get("http://localhost:8080/FlyAway/signup");
		
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='pwd2']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("test@test.com");
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/button")).click();
		
		driver.findElement(By.xpath("//a[text()='Login/Signup']")).click();
	}
	
	public void login() {
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("test");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("/html/body/a[1]")).click();
	}
	
	public void search(String origin, String destination) {
		WebElement sourceWE = driver.findElement(By.xpath("//select[@name='source']"));
		Select source = new Select(sourceWE);
		source.selectByVisibleText(origin);
		
		WebElement destWE = driver.findElement(By.xpath("//select[@name='destination']"));
		Select dest = new Select(destWE);
		dest.selectByVisibleText(destination);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[3]/button")).click();
	}
	
	void book() {
		try {
			driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[6]/a")).click();
			System.out.println("***** ***** *****\nFlight Booked Successfully\n***** ***** *****");
			
		} catch(Exception E) {
			System.out.println("***** ***** *****\nFlight Not Booked Successfully\n***** ***** *****");
		}
	}
	
	void close() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
