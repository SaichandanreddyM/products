package proflaut_Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proflaut_Dto.Product;
import proflaut_Dto.Subproduct;

public class Controller {
Scanner sc = new Scanner(System.in);
	
	product_Dao dao = new product_Dao();
	
	
	public void saveProduct() {
		Product p = new Product();;
		System.out.println("enter product Type");
		p.setProd_Type(sc.next());
		System.out.println("enter product Name");
		p.setProd_name(sc.next());
		List<Subproduct> subproducts = new ArrayList<Subproduct>();
		p.setP(subproducts);
		if(dao.saveProduct(p)!=null) {
			System.out.println("product saved successfully");
		}else {
			System.out.println("failure");

		}
	}
	
	public void findProduct() {
		System.out.println("enter the product id");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		if(p!=null) {
			System.out.println(p.getProd_Id()+"   "+p.getProd_Type()+"   "+p.getProd_name());
		}else {
			System.out.println("failure");

		}
		
	}
	
	public void deleteProduct() {
		System.out.println("enter the id of the product you want to delete");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		if(p!=null) {
			dao.deleteproduct(id);
			System.out.println("product deleted successfully");
		}else {
			System.out.println("failure");

		}
	}
	
	public void findAllProduct() {
		List<Product> allProducts = dao.getAllProducts();
		for(Product p : allProducts) {
			System.out.println("id"+"      "+"Type"+"    "+"name");
			System.out.println(p.getProd_Id()+"     "+p.getProd_Type()+"    "+p.getProd_name());
		}
	}
	
	public Product updateProduct() {
		
		List<Product> products = dao.getAllProducts();
		for(Product p : products) {
			System.out.println(p.getProd_Id()+"      "+p.getProd_name());
		}
		
		System.out.println("enter the id of the product you need to update");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		System.out.println("choose your options");
		System.out.println("1 :  update type");
		System.out.println("2 :  update name");
		int choice = sc.nextInt();
		if(choice==1) {
			System.out.println("enter the updated type");
			p.setProd_Type(sc.next());
			return  dao.updateProduct(p, id);
		}
		if(choice==2) {
			System.out.println("enter the updated name");
			p.setProd_name(sc.next());
			return  dao.updateProduct(p, id);
		}
		return p;
	}
	
	public void saveSubProduct() {
		
		List<Product> products = dao.getAllProducts();
		for(Product p : products) {
			System.out.println(p.getProd_Id()+"      "+p.getProd_Type());
		}
		
		System.out.println("enter the product id to which you want to add the sub product");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		
		Subproduct sub = new Subproduct();
		System.out.println("enter the sub product brand");
		sub.setSub_brand(sc.next());
		System.out.println("enter the sub product price");
		sub.setPrice(sc.nextDouble());
		sub.setProd(p);
		p.getP().add(sub);
		
		
		
		
		if(p!=null) {
			dao.saveSubProduct(sub);
			Product updated = dao.updateProduct(p, id);
			System.out.println("sub product save success");
		}
		
		else {
			System.out.println("failure");

		}
		
		
	}
	
	public void findAllSubProducts() {
		List<Product> products = dao.getAllProducts();
		for(Product p : products) {
			System.out.println(p.getProd_Id()+"      "+p.getProd_Type());
		}
		
		System.out.println("enter the product id to display all the products");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		for(Subproduct sp : p.getP()) {
			System.out.println(sp.getSub_Id()+"  "+sp.getSub_brand()+"  "+sp.getPrice());
		}	
	}
	
	public void deleteSubProduct() {
		List<Product> products = dao.getAllProducts();
		for(Product p : products) {
			System.out.println(p.getProd_Id()+"      "+p.getProd_Type());
		}
		
		System.out.println("enter the product id from where you want to delete a subproduct");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		
		for(Subproduct sp : p.getP()) {
			System.out.println(sp.getSub_Id()+"  "+sp.getSub_brand()+"  "+sp.getPrice());
		}
		
		System.out.println(" enter the sub product ID you want to delete");
		
		int subid = sc.nextInt();
		Subproduct subproducttobedeleted = dao.findSubProduct(subid);
		
		p.getP().remove(subproducttobedeleted);
		subproducttobedeleted.setProd(null);
		
		dao.updateProduct(p, id);
		dao.deletesubProduct(subid);
		
	
	}
	
	public void updateSubProduct() {
		List<Product> products = dao.getAllProducts();
		for(Product p : products) {
			System.out.println(p.getProd_Id()+"      "+p.getProd_Type());
		}
		
		System.out.println("enter the product id from where you want to delete a subproduct");
		int id = sc.nextInt();
		Product p = dao.findProduct(id);
		
		for(Subproduct sp : p.getP()) {
			System.out.println(sp.getSub_Id()+"  "+sp.getSub_brand()+"  "+sp.getPrice());
		}
		
		System.out.println(" enter the sub product ID you want to update");
		int subid = sc.nextInt();
		Subproduct subproducttobeupdated = dao.findSubProduct(subid);
		
		System.out.println("choose your options");
		System.out.println("1 : update brand");
		System.out.println("2 : update price");
		int choice = sc.nextInt();
		if(choice==1) {
			System.out.println("enter the updated brand");
			subproducttobeupdated.setSub_brand(sc.next());
			dao.updateSubProduct(subproducttobeupdated, subid);
		}
		if(choice==2) {
			System.out.println("enter the updated price");
			subproducttobeupdated.setPrice(sc.nextDouble());
			dao.updateSubProduct(subproducttobeupdated, subid);
		}
		else {
			System.out.println("failure");

		}
	}
}
