public class UseConnectTEST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTEST ct = new ConnectTEST();
		ct.connect();
		//ct.insert();
		//ct.update("4444", 25);
		ct.showAllStudents();
//		ct.delete("2222");
//		ct.delete("7777");
		ct.findBeetweenAges(25, 30);
//		ct.searchByName();
//		ct.insertFromFile("registro_archivo.txt");
		ct.closeConnection();
	}
	
}