package reviewPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testAll {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		flyAway fa = new flyAway(driver);
		
		fa.register();
		fa.login();
		fa.search("Bangalore", "Hyderabad");
		fa.book();
		fa.close();
	}
}
