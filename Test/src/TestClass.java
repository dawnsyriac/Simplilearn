import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
ChromeDriver cd=Initilize.amazon();
Connection con=DBUtil.getConnection();
int i=0;
cd.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("samsung");
cd.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
cd.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
String prod1 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).getText();
String price1 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[2]")).getText();
Save(con,prod1,price1);
String prod2 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).getText();
String price2 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[2]")).getText();
Save(con,prod2,price2);
String prod3 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[6]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).getText();
String price3 = cd.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[6]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[2]/a/span[1]/span[2]/span[2]")).getText();
Save(con,prod3,price3);
i=search(con,prod1,price1);
if(i==1)
{
	System.out.println("Product 1 found in DB");
}
i=search(con,prod2,price2);
if(i==1)
{
	System.out.println("Product 2 found in DB");
}
i=search(con,prod3,price3);
if(i==1)
{
	System.out.println("Product 3 found in DB");
}
    }
static void Save(Connection con, String a, String i) throws SQLException, ClassNotFoundException
	{
		
		String sql="insert into samsung_products values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,a);
		ps.setString(2,i);
		ps.executeUpdate();
		
	}
static int search(Connection con, String a, String i) throws SQLException
{
	//System.out.println("entered into search");
	int j=0;
	Statement stmt = con.createStatement();
    String query = "select * from samsung_products";
    ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String desc = rs.getString(1);
            String price = rs.getString(2);
            if(a.equals(desc)&&i.equals(price))
            {
            	j=1;
            	//System.out.println("found");
            	return j;
            }
        }
        //System.out.println("notfound");
     return j;
}
}