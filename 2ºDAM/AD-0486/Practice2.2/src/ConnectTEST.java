import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class ConnectTEST {
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
			System.out.println("jdbc:mysql://localhost/test "+ "closed");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void insert() {
		Scanner sc=new Scanner(System.in);
		String nif,name;
		int age;
		try {
			System.out.println("Write the information of the new student for the database:");
			System.out.println("NIF?");
			nif = sc.nextLine();
			System.out.println("Name?");
			name = sc.nextLine();
			System.out.println("age?");
			age = Integer.parseInt(sc.nextLine());
			// Create a statement
			Statement st = con.createStatement();
			// Execute the insertion
			// st.executeUpdate("INSERT INTO students
			// VALUES('4444','Diego',17)");
			st.executeUpdate("INSERT INTO students VALUES('" + nif + "','" + name + "'," + age + ")");
			// String sql=String.format("INSERT INTO students
			// VALUES('%s','%s',%d)",nif,name,age);

			// st.executeUpdate(sql);
			// close the statement
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void update(String nif, int age) {
		String sql;
		try {
			System.out.println("Updating....");
			// Create a statement
			Statement st = con.createStatement();
			// Execute the updating
			// st.executeUpdate("UPDATE students SET AGE=20 WHERE
			// students.NIF='3333'");
			sql = String.format("UPDATE students SET AGE=%d WHERE students.NIF='%s'", age, nif);
			st.executeUpdate(sql);
			// close the statement
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-Add the method void showAllStudents(): the method shows all the information of the studens in the table
	void showAllStudents() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT * FROM students");
			while(resul.next()){
				//aquí tambien podriamos poner resul.getInt("nif");
				System.out.printf("%d, %s, %s \n", resul.getInt(1), resul.getString(2), resul.getString(3));
				}
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-Add the method void detelete(String nif): the method deletes the student with the nif. If there is no student with that nif, the code shows a message saying “There is no student with nif ….”
	
	void delete (String nif) {
		try {
		Statement st = con.createStatement();
		int resul = st.executeUpdate("DELETE FROM students where students.nif = '"+nif+"'");
		if (resul > 0){
			System.out.printf("Deleting went ok");
			}else{System.out.printf("There's no student with nif " + nif);}
		st.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	//-Add the method int searchByName(): the metod asks a name by console and shows the information of all the students that have that name.
	
	void searchByName() {
		Scanner sc=new Scanner(System.in);
		String name;
		try {
			// Create a statement
			System.out.println("Name?");
			name = sc.nextLine();
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT * FROM students where students.name = '"+name+"'");
			while(resul.next()){
				System.out.printf("%d, %s, %s \n", resul.getInt(1), resul.getString(2), resul.getString(3));
				}
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//-Add the method int findBetweenAges(int minAge,int maxAge): find all the students between the minimun and maximum age.
	int findBeetweenAges(int minAge, int maxAge) {
		try {
			int resultado = 0;
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT COUNT(*) FROM students where age BETWEEN " + minAge +" and " + maxAge );
			resul.next();
			resultado = resul.getInt(1);
			System.out.println("Number of students in beetween " + minAge + " and " + maxAge + " : " + resultado);
			resul.close();
			st.close();
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/*-Add the method insertFromFile(String filename): the metods reads the values of the students from a csv document where the information os students is stored in rows separated by commas.
	Example: file newStudents.txt:
	6666,felipe,18
	7777,amelia,16
	(supongo que será con algo tipo split) 
	 */
	void insertFromFile(String filename){
		
		String nif,name;
		int age;
		try {
			Scanner scnr = new Scanner( new File(filename) );
			
			// Create a statement
			Statement st = con.createStatement();
			String[] estudiante;
			while(scnr.hasNextLine()) {
				String line = scnr.nextLine();	
				estudiante = line.split(",");
				nif = estudiante[0];
				System.out.println(estudiante[0]);
				name = estudiante[1];
				age = Integer.parseInt(estudiante[2]);
				st.executeUpdate("INSERT INTO students VALUES('" + nif + "','" + name + "'," + age + ")");
			}
			scnr.close(); // Put this call in a finally block
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
