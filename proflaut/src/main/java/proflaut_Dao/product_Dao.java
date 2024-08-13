package proflaut_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proflaut_Dto.Product;
import proflaut_Dto.Subproduct;
public class product_Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proflaut");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Product saveProduct(Product p) {
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}
	
	public Product findProduct(int productId) {
		Product p = em.find(Product.class, productId);
		if(p!=null) {
			return p;
		}
		else {
			return null;
		}
	}
	
	public Product deleteproduct(int ProductId) {
		Product p = em.find(Product.class, ProductId);
		if(p!=null) {
			et.begin();
			em.remove(p);
			et.commit();
			return p;
		}
		else {
			return null;
		}
	}
	
	public Product updateProduct(Product p, int productId) {
		Product dbproduct = em.find(Product.class, productId);
		if(dbproduct!=null) {
			p.setProd_Id(productId);
			et.begin();
			em.merge(p);
			et.commit();
		}
		return null;
	}
	
	public List<Product> getAllProducts(){
		Query query = em.createQuery("select P from Product P");
		List<Product> allproducts = query.getResultList();
		if(!allproducts.isEmpty()) {
			return allproducts;
		}
		else {
			return null;
		}
	}
	
	
	public Subproduct saveSubProduct(Subproduct p) {
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}
	
	public Subproduct findSubProduct(int subProductId) {
		Subproduct p = em.find(Subproduct.class, subProductId);
		if(p!=null) {
			return p;
		}
		else {
			return null;
		}
	}
	
	public Subproduct deletesubProduct(int SubProductId) {
		Subproduct p = em.find(Subproduct.class, SubProductId);
		if(p!=null) {
			et.begin();
			em.remove(p);
			et.commit();
			return p;
		}
		else {
			return null;
		}
	}
	
	public Subproduct updateSubProduct(Subproduct p, int subProductId) {
		Subproduct dbsubProduct = em.find(Subproduct.class, subProductId);
		if(dbsubProduct!=null) {
			p.setSub_Id(subProductId);
			et.begin();
			em.merge(p);
			et.commit();
		}
		return null;
	}
	
	public List<Subproduct> getAllSubProducts(){
		Query query = em.createQuery("select P from SubProduct P");
		List<Subproduct> allsubProducts = query.getResultList();
		if(!allsubProducts.isEmpty()) {
			return allsubProducts;
		}
		else {
			return null;
		}
	}

	
	
	
	

}
