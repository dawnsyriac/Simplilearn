import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBUtil {
	public final static String url="jdbc:mysql://localhost:3306/amazon";
	public final static String username="dawn";
	public final static String password="test";
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,username,password);
	return con;
	}

}