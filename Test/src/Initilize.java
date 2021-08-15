import org.openqa.selenium.chrome.ChromeDriver;

public class Initilize {
	static ChromeDriver amazon()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver cd = new ChromeDriver();
	cd.manage().window().maximize();
	cd.get("https://amazon.in/");
	return cd;
	}
}
