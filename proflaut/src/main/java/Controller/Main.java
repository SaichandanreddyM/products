package Controller;

import java.util.Scanner;

import proflaut_Dao.Controller;

public class Main {
public static void main(String[] args) {

		
		
		boolean bool = true;

		while (bool) {
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome TO The Page");

			System.out.println("1  create the product You want");
			System.out.println("2  find the product");
			System.out.println("3  find all product");
			System.out.println("4  update product");
			System.out.println("5  delete product");
			System.out.println("6  create the SubPRoduct");
			System.out.println("7  find subProducts");
			System.out.println("8  delete subproducts");
			System.out.println("9  Exit");

			System.out.println("select the option you need to work on");

			int op = sc.nextInt();

			Controller c = new Controller();

			switch (op) {
			case 1:
				c.saveProduct();
				break;
				
			case 2:
				c.findProduct();
				break;
				
			case 3:
				c.findAllProduct();
				
				break;
				
			case 4:
				c.updateProduct();
				break;
				
			case 5:
				c.deleteProduct();
				break;
				
			case 6:
				c.saveSubProduct();
				break;
				
			case 7:
				c.findAllSubProducts();
				break;
				
			case 8:
				c.deleteSubProduct();
				break;
				
			case 9:
				System.out.println("Thank You----");
				bool=false;
				break;

			default:
				System.out.println("Invalid");

				break;
			}

		}

	}

}
