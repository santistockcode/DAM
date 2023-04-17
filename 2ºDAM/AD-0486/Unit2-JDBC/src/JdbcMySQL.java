import java.sql.*;

public class JdbcMySQL {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/test";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Open the connection with the 3 arguments (url,user,password)
			Connection conexion=DriverManager.getConnection(url,"root","");
			//if the connection fails, there is an exception here
			System.out.println("CONNECTED TO DATABASE "+ url);
			//Create the SQL sentence to execute in the database
			Statement sentence=conexion.createStatement();
			String sql="SELECT * FROM students";
			//execute the sentence, obtaining a relset
			ResultSet resul=sentence.executeQuery(sql);
			//process the resulset with the methos resul.next()
			while(resul.next()){
				System.out.printf("%d,%s,%s,%n",resul.getInt(1),resul.getString(2),resul.getString(3));
			}
			resul.close();
			sentence.close();
			//close the connection
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
