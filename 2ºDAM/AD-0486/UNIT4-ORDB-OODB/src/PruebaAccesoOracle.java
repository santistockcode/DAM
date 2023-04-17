import java.sql.*;
public class PruebaAccesoOracle {
	private Connection con;
	void abrirConexion() {		
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
						"santidb","ad2021");
	
				System.out.println("Connection OK");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	void cerrarConexion() {
		try{
			System.out.println("Clossing");
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	void showInfo() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT c.name, c.phone FROM contacts c");
			System.out.println("SHOW ALL INFORMATION--------------");
			
			while(resul.next()){
				//aquí tambien podriamos poner resul.getInt("nif");
				System.out.printf("\nNOMBRE: %s\nTELEFONO: %s", resul.getString(1), resul.getString(2));
				}
			System.out.println("\n--------------");
			resul.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		//Write the code to show the information in “ADMITTED”:
		//o 2.1. Show the information in the field “day”, which is simple.
		void showDay() {
			try {
				// Create a statement
				Statement st = con.createStatement();
				ResultSet resul = st.executeQuery("SELECT a.day FROM admitted a");
				System.out.println("DAY IN ADMITTED--------------");
				while(resul.next()){
					//aquí tambien podriamos poner resul.getInt("nif");
					java.util.Date date = new java.util.Date();
					Timestamp timestamp = resul.getTimestamp(1);
					if (timestamp != null)
					    date = new java.util.Date(timestamp.getTime());
					System.out.printf("\nDAY: " + date);
					}
				System.out.println("\n--------------");
				resul.close();
				st.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void showRestAdmitted() {
			try {
				// Create a statement
				Statement st = con.createStatement();
				ResultSet resul = st.executeQuery("SELECT * FROM admitted a");
				System.out.println("ALL INFO IN IN ADMITTED--------------");
				while(resul.next()){
					//FECHA
					java.util.Date date = new java.util.Date();
					Timestamp timestamp = resul.getTimestamp(1);
					if (timestamp != null)
					    date = new java.util.Date(timestamp.getTime());
					System.out.printf("\nDAY: " + date);
					//OBJETO ONLY_STUDIES
					oracle.sql.STRUCT student = (oracle.sql.STRUCT) resul.getObject(2);
					Object[] atributos = student.getAttributes();
					String id_student = (String) atributos[0];
					System.out.println("\n id: " + id_student);
						//OBJECTO PERSON ANIDADO EN ONLYSTUDIES
					oracle.sql.STRUCT person = (oracle.sql.STRUCT) atributos[1];
					Object[] atributos_person = person.getAttributes();
					String name = (String) atributos_person[0];
					String phone = (String) atributos_person[0];
					System.out.println("\n Nombre: " + name);
					System.out.println("\n Teléfono: " + phone);

					}
				System.out.println("\n--------------");
				resul.close();
				st.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}