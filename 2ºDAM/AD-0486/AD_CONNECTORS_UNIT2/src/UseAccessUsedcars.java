
public class UseAccessUsedcars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessUsedcars ct = new AccessUsedcars();
		ct.connect();
		ct.showAllInformation();
		ct.insertnewcar();
		ct.deletecar("LLLL 444");
		ct.updateBajalePrecio();
		ct.showInfoYear(2018);
		ct.closeConnection();
	}

}
