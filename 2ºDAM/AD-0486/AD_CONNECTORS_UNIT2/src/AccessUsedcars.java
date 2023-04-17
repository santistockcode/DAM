import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AccessUsedcars {
	private Connection con;
	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			//if the connection fails, there is an exception here
			System.out.println("CONNECTED TO DATABASE "+ "jdbc:mysql://localhost/test");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void closeConnection() {
		try {
			con.close();
			System.out.println("\njdbc:mysql://localhost/test "+ "closed");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void showAllInformation() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT * FROM usedcars");
			System.out.println("SHOW ALL INFORMATION--------------");
			while(resul.next()){
				//aquí tambien podriamos poner resul.getInt("nif");
				System.out.printf("\nPLATE: %s\nMODEL: %s\nYEAR: %d\nPRICE: %d\nSOLD: %s \n", resul.getString(1), resul.getString(2),
						resul.getInt(3), resul.getInt(4), boolIntAString(resul.getInt(5)));
				}
			System.out.println("--------------");
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void insertnewcar() {
		Scanner sc=new Scanner(System.in);
		String plate,model;
		int year, price, sold;
		
		try {
			System.out.println("Write the information of the used car for the database:");
			System.out.println("PLATE?");
			plate = sc.nextLine();
			System.out.println("MODEL?");
			model = sc.nextLine();
			System.out.println("YEAR?");
			year = Integer.parseInt(sc.nextLine());
			System.out.println("PRICE?");
			price = Integer.parseInt(sc.nextLine());
			System.out.println("SOLD? (WRITE 1 FOR TRUE, 0 FOR FALSE)");
			sold = Integer.parseInt(sc.nextLine());
			// Create a statement
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO usedcars VALUES('" + plate + "','" + model + "'," + year + "," + price + "," + sold + ")");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String boolIntAString(int tini) {
		if (tini == 1) {return "true";}
		if (tini == 0) {return "false";}
		return null;
	}
	
	void deletecar (String plate) {
		try {
		Statement st = con.createStatement();
		int resul = st.executeUpdate("DELETE FROM usedcars where usedcars.plate = '"+plate+"'");
		if (resul > 0){
			System.out.printf("Deleting went ok");
			}else{System.out.printf("There's no car with plate " + plate);}
		st.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	void updateBajalePrecio() {
		String sql;
		try {
			String post;
			System.out.println("Discount 20% of cars not sold--------------");
			Scanner scnr = new Scanner(System.in);
			// Create a statement
			Statement st = con.createStatement();
			sql = "UPDATE usedcars SET price = price * 0.8 WHERE usedcars.sold = 0";
			st.executeUpdate(sql);
			// close the statement
			st.close();
			System.out.println("--------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void showInfoYear(int year) {
		Scanner sc=new Scanner(System.in);
		try {
			// Create a statement
			Statement st = con.createStatement();
			System.out.println("Showing cars from year " + year);
			ResultSet resul = st.executeQuery("SELECT * FROM usedcars where usedcars.year = "+year+"");
			while(resul.next()){
				System.out.printf("\nPLATE: %s\nMODEL: %s\nYEAR: %d\nPRICE: %d\nSOLD: %s \n", resul.getString(1), resul.getString(2),
						resul.getInt(3), resul.getInt(4), boolIntAString(resul.getInt(5)));
			}
			resul = st.executeQuery("SELECT COUNT(*) FROM usedcars where usedcars.year = "+year+"");
			while(resul.next()){
				System.out.printf("\nTOTAL: %d\n", resul.getInt(1));
			}
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



