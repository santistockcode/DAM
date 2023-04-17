package MyPackEnterprise;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateEnterprise3_1 {
	private static SessionFactory sf; 
	
	HibernateEnterprise3_1(){//constructor
		sf = HibernateUtil.getSessionFactory();
	}
	public void close() {
		sf.close();
	}
	
		//a. Show all clients in the table.
	public void showClients() {
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List allclients = session.createQuery("FROM Client").list();
			Iterator it = allclients.iterator();
			while(it.hasNext()){
			Client c = (Client) it.next();
			System.out.print("Id: " + c.getId());
			System.out.print(" ,Name: " + c.getName());
			System.out.println(" ,Country: " + c.getCountry());
			}
			tx.commit();
			} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
				session.close();
				
			}
	}
		//b. addClient(int id, String name, String country)
	public void addClient(int id, String name, String country) {
		Session session=sf.openSession();
		Transaction tx=null;
		Client c=new Client();
		c.setId(id);
		c.setName(name);
		c.setCountry(country);
			try{
				System.out.printf("Inserting a row in the database: %s, %s, %s\n",id,name,country);
				tx=session.beginTransaction();
				session.save(c);//we INSERT p into the table PRODUCTS
				tx.commit();//if session.save doesn&#39;t produce an exception, we "commit" the transaction
			}catch(Exception e){//if there is any exception, we "rollback" and closesafely
				if (tx!=null) {
					tx.rollback();
				}
			}finally{
				session.close();
			}
	}
		//c. deleteClient(int id): deletes the client or shows a message saying “Client id notfound”
	public void deleteClient(int id) {
		Client c =new Client();
		Session session=sf.openSession();
		Transaction tx=null;
			try{
				tx=session.beginTransaction();
				c=(Client)session.load(Client.class, id);
				session.delete(c);
				tx.commit();
				System.out.printf(
						"Object deleted FROM THE DATABASE: %s, %s, %s\n",
						c.getId(), c.getName(), c.getCountry());
			}catch(Exception e){
				if(tx!=null){
					System.out.printf("not found product by id: " + id);
					tx.rollback();
				}
			}finally{
				session.close();
			}
	}
	
	public void updateClient(int id, String newName, String newCountry) {	
		Client c=new Client();
		Session session=sf.openSession();
		Transaction tx=null;
		try{
		tx=session.beginTransaction();
		System.out.println("Updating a value by id inserted");
		System.out.println("Before updating, we need to load the object");

		c=(Client)session.load(Client.class, id);//we load the client
		c.setName(newName);//we change the properties
		c.setCountry(newCountry);
		session.update(c);//we update the values in the database
		tx.commit();
		System.out.println("Object updated");
		}catch(Exception e){
			System.out.println("Not found client by id " + id);
			System.out.println(e);
			if(tx!=null){
			tx.rollback();
			}
			}finally{
			session.close();
			}
	}
	
	
	/*
			  : deletes the client with the name. If the client
		doesn’t exist shows a message “Client not found”. COMMENT: IN THIS CASE,
		WE CANNOT LOAD THE CLIENTE BECAUSE WE DON’T KNOW DE ID. WE NEED
		TO HAVE THE LIST OF CLIENTS AND TRAVERSE IT LOOKING FOR THE NAME)
		*/
	public void deleteClient(String name) {
		Session session=sf.openSession();
		Transaction tx=null;
			try{
				tx = session.beginTransaction();
				List allclients = session.createQuery("from Client as cli where cli.name like '" + name + "%'").list();
				Iterator it = allclients.iterator();
				while(it.hasNext()){
				Client c = (Client) it.next();
				System.out.print("DELETING--> ");
				System.out.print("Id: " + c.getId());
				System.out.print(" ,Name: " + c.getName());
				System.out.println(" ,Country: " + c.getCountry());
				session.delete(c);
				}
				if (allclients.size() ==0) {System.out.printf("not found CLIENTS by name: " + name);}
				tx.commit();
			}catch(Exception e){
				if(tx!=null){
					tx.rollback();
				}
			}finally{
				session.close();
			}
	}
	/*
	 * First the method looks for the client with the id. If it
			 * exists, it shows you the values of the name and country. Then, the method
		asks you if you want to update the name. If you answer “yes”, it asks you the
		new name. Then the program asks you if you want to update the country. If
		you say yes, the program asks you for the new name. Then updates the record
		it the database with the new values.
	 * 
	 */
	public void updateClient(int id) {
		Client c=new Client();
		Session session=sf.openSession();
		Transaction tx=null;
		String newName = "default Name";
		String newCountry = "default Country";
		try{
		tx=session.beginTransaction();
		

		c=(Client)session.load(Client.class, id);//we load the client
		
		System.out.print("Id: " + c.getId());
		System.out.print(" ,Name: " + c.getName());
		System.out.println(" ,Country: " + c.getCountry());
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Do you want to update the name of this client? s/n");	
	    String userName = myObj.nextLine();  // Read user input
	    if(userName.equalsIgnoreCase("s")) {

	        System.out.println("Fetén! Enter the new name:");

	        newName = myObj.nextLine();  // Read user input
	        
	        c.setName(newName);
	    }else if(userName.equalsIgnoreCase("n")) {}
		//we change the properties
		
		
		System.out.println("Do you want to update the country of this client? s/n");	
	    String userCountry = myObj.nextLine();  // Read user input
	    if(userCountry.equalsIgnoreCase("s")) {
	        System.out.println("Fetén! Enter the new country:");
	        newCountry = myObj.nextLine();  // Read user input
	        c.setCountry(newCountry);
	    }else if(userName.equalsIgnoreCase("n")) {}
		session.update(c);//we update the values in the database
		tx.commit();
		System.out.println("Object updated");
		}catch(Exception e){
			System.out.println("Not found client by id " + id);
			System.out.println(e);
			if(tx!=null){
			tx.rollback();
			}
			}finally{
			session.close();
			}
	}
	/*
		 *  All the client that have the country. Show
	how many clients we have in that country(USING HQL)
	*/
 public void showByCountry(String country) {
	 Session session = sf.openSession();
     Transaction tx = null;
     
     try {	
        tx = session.beginTransaction();
        List allclients = session.createQuery("from Client as prod where prod.country like '" + country + "%'").list(); 
        Iterator iterator = allclients.iterator();
        while(iterator.hasNext()){
       // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
           Client c = (Client) iterator.next(); 
           System.out.print("Id: " + c.getId()); 
           System.out.print("  ,Name: " + c.getName()); 
           System.out.println("  ,Country: " + c.getCountry()); 
        }
        System.out.println("hay tantos resultados : "+ allclients.size());
        tx.commit();
     } catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     } finally {
        session.close(); 
     }
 }
	 /*
	  *  Ask the user for the name of a client by console,
	and look for the country in the database.(USING HQL)
	 */
  public void countryOf(String name) {
	  Session session = sf.openSession();
	     Transaction tx = null;
	     int cont = 0;
	     
	     try {	
	        tx = session.beginTransaction();
	        List allclients = session.createQuery("from Client as prod where prod.name like '" + name + "%'").list(); 
	        Iterator iterator = allclients.iterator();
	        while(iterator.hasNext()){
	       // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	           Client c = (Client) iterator.next(); 
	           System.out.println("Person named " + name + " number: " + cont);
	           cont++;
	           System.out.println("  ,Country: " + c.getCountry()); 
	        }
	        tx.commit();
	     } catch (HibernateException e) {
	        if (tx!=null) tx.rollback();
	        e.printStackTrace(); 
	     } finally {
	        session.close(); 
	     }
  }
}
