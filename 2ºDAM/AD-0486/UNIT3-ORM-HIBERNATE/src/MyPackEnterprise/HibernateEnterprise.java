package MyPackEnterprise;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import MyPackEnterprise.*;

public class HibernateEnterprise {
	
	private static SessionFactory sf; 
	
	HibernateEnterprise(){//constructor
		sf = HibernateUtil.getSessionFactory();
		//sf=new Configuration().configure().buildSessionFactory //also works
	}
	public void close() {
		sf.close();
	}
	public void addProduct(int id,String name, double price ){
		Session session=sf.openSession();
		Transaction tx=null;
		Products p=new Products();
		p.setName(name);
		p.setPrice(price);
		p.setProductId(id);
			try{
				System.out.printf("Inserting a row in the database: %s, %s, %s\n",id,name,price);
				tx=session.beginTransaction();
				session.save(p);//we INSERT p into the table PRODUCTS
				tx.commit();//if session.save doesn&#39;t produce an exception, we "commit" the transaction
			}catch(Exception e){//if there is any exception, we "rollback" and closesafely
				if (tx!=null) {
					tx.rollback();
				}
			}finally{
				session.close();
			}
	}
	public void showProducts() {
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List allproducts = session.createQuery("FROM Products").list();
			Iterator it = allproducts.iterator();
			while(it.hasNext()){
			Products p = (Products) it.next();
			System.out.print("Id: " + p.getProductId());
			System.out.print(" ,Name: " + p.getName());
			System.out.println(" ,Price: " + p.getPrice());
			}
			tx.commit();
			} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
				session.close();
				
			}
		}
	public Products findProductById(int id){
		Session session=sf.openSession();
		Transaction tx=null;
		Products p=new Products();
			try{
				System.out.println("loading the object from the database");
				tx=session.beginTransaction();
				p=(Products)session.load(Products.class, id);//esto es lo importante
				tx.commit();
				System.out.println("The product with id="+id+" is:"+p.getName());
			}catch(ObjectNotFoundException e){
				if(tx!=null){
					System.out.println(e);
					System.out.println("Product not found");
				}
			}catch(Exception e){
				if(tx!=null){
					System.out.println(e);
					tx.rollback();
				}
			}
			finally{
				session.close();
			}
			return p;
	}
	public void deleteProductById(int id){
		Products p=new Products();
		Session session=sf.openSession();
		Transaction tx=null;
			try{
				tx=session.beginTransaction();
				p=(Products)session.load(Products.class, id);
				session.delete(p);
				tx.commit();
				System.out.printf(
						"Object deleted FROM THE DATABASE: %s, %s, %s\n",
						p.getProductId(),p.getName(),p.getPrice());
			}catch(Exception e){
				if(tx!=null){
					System.out.printf("not found");
					tx.rollback();
				}
			}finally{
				session.close();
			}
		}
	public void updateProductById(int id,String newName,double newPrice){

		Products p=new Products();
		Session session=sf.openSession();
		Transaction tx=null;
		try{
		tx=session.beginTransaction();
		System.out.println("Updating a value");
		System.out.println("Before updating, we need to load the object");

		p=(Products)session.load(Products.class, id);//we load the pen
		p.setPrice(newPrice);//we change the properties
		p.setName(newName);
		session.update(p);//we update the values in the database
		tx.commit();
		System.out.println("Object updated");
		}catch(Exception e){
			System.out.println("not found object by id " + id);
			System.out.println(e);
			if(tx!=null){
			tx.rollback();
			}
			}finally{
			session.close();
			}
	}	

	public void showProducts3_3(){

		Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try {	
	         tx = session.beginTransaction();
	         List allproducts = session.createQuery("FROM Products").list(); 
	         Iterator iterator = allproducts.iterator();
	         while(iterator.hasNext()){
	        // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	            Products p = (Products) iterator.next(); 
	            System.out.print("Id: " + p.getProductId()); 
	            System.out.print("  ,Name: " + p.getName()); 
	            System.out.println("  ,Price: " + p.getPrice()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

	public void showByName(String name) {

		Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try {	
	         tx = session.beginTransaction();
	         List allproducts = session.createQuery("from Products as prod where prod.name like '" + name + "%'").list(); 
	         Iterator iterator = allproducts.iterator();
	         while(iterator.hasNext()){
	        // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	            Products p = (Products) iterator.next(); 
	            System.out.print("Id: " + p.getProductId()); 
	            System.out.print("  ,Name: " + p.getName()); 
	            System.out.println("  ,Price: " + p.getPrice()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	public void productsOrderedByPrice(){
		Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try {	
	         tx = session.beginTransaction();
	         List allproducts = session.createQuery("from Products p order by p.price").list(); 
	         Iterator iterator = allproducts.iterator();
	         while(iterator.hasNext()){
	        // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	            Products p = (Products) iterator.next(); 
	            System.out.print("Id: " + p.getProductId()); 
	            System.out.print("  ,Name: " + p.getName()); 
	            System.out.println("  ,Price: " + p.getPrice()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	public void priceOf(String name) {

		Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try {	
	         tx = session.beginTransaction();
	         List allproducts = session.createQuery("from Products as prod where prod.name like '" + name + "%'").list(); 
	         Iterator iterator = allproducts.iterator();
	         System.out.println("Hay este número de productos de nombre " + name + " : " + allproducts.size());
	         while(iterator.hasNext()){
	        // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	            Products p = (Products) iterator.next(); 
	            System.out.print("Id: " + p.getProductId()); 
	            System.out.print("  ,Name: " + p.getName()); 
	            System.out.println("  ,Price: " + p.getPrice()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}

	public void findProduct(int id) {

		Session session = sf.openSession();
	      Transaction tx = null;
	      
	      try {	
	         tx = session.beginTransaction();
	         Products allproducts = (Products) session.createQuery("from Products as prod where prod.id = " + id).uniqueResult(); 
	         System.out.print("  ,Name of the product with id " + id + " : " + allproducts.getName()); 
	         //Iterator iterator = allproducts.iterator();
	         //while(iterator.hasNext()){
	        // for (Iterator iterator = allproducts.iterator(); iterator.hasNext();){
	          
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
	}
}