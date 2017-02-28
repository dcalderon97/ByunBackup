/*
 * Title:OnlineStore.java
 * Abstract: Creates a simulation of a store creating orders and items
 * Name:Daniel Calderon
 * Date: 2 /26/17
 * ID: 3083
 */
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class OnlineStore {
	private String name;
	private ArrayList<Product> product = new ArrayList<Product>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	//Methods
	boolean updateProduct()
	{
		int productNumber;
		int count =0;
		String input = "";
		String trash;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Product Number To Update: ");
		productNumber = keyboard.nextInt();
		for(Product p : product)
		{
			if(p.getProductNum() == productNumber)
			{
				System.out.println("If you do not want to change data, press enter key.");
				input = keyboard.nextLine();
				System.out.print("Product Name ("+p.getProductName() +"): " );
				input = keyboard.nextLine();
				if(input.length() >0)
				{
					p.setProductName(input);
				}
				input = "";
				System.out.print("Product price ("+p.getUnitPrice() +")" );
				input = keyboard.nextLine();
				if(input.length() >0)
				{
					p.setUnitPrice(Double.parseDouble(input));
				}
				System.out.println("Product Update - "+p.getProductName()+", "+
				"No: "+p.getProductNum() +", Price: " + p.getUnitPrice());
				return true;
			}
				
		}
		System.out.println("Input error: Product "+productNumber+" doesn't exists." );
		return false;
	}
	boolean makeOrder(){
		String trash;
		int orderNum;
		int productNum;
		int count =0;
		boolean cont = true;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Order Number: ");
		orderNum = keyboard.nextInt();
		for(Order o: orders)
		{
			if(o.getOrderNum() == orderNum)
			{
				System.out.format("Error: Order %d already exists",orderNum);
				return false;
			}
		}
		while(cont)
		{
			orders.add(new Order(orderNum));
			System.out.print("Type Product Number (0 to finish):");
			productNum = keyboard.nextInt();
			if(productNum == 0)
			{
				cont = false;
				break;
			}
			for(Product p : product)
			{
				if(p.getProductNum() == productNum)
				{
					count++;
					for(Order o: orders)
					{
						if(o.getOrderNum() == orderNum)
						{
							o.addItem(p.getProductNum(),p.getProductName(),p.getUnitPrice());
							o.setTotalPrice(p.getUnitPrice());
						}
					}
				}
			}
			if(count == 0)
			{
				System.out.println("Error: " + productNum + " does not exist");
			}
			
		}
		System.out.format("Order info - Order Number: %d \n", orderNum);
		for(Order o: orders)
		{
			if(o.getOrderNum() == orderNum)
			{
				o.getItems();
				System.out.format("		Total Price: %.2f \n",o.getTotalPrice());
				return true;
			}
		}
		return true;
	}
	public OnlineStore(String val)
	{
		this.name = val;
	}
	boolean addProduct(){
		int num;
		String name;
		double price;
		String trash;
		
		Scanner keyboard  = new Scanner(System.in);
		System.out.print("Product Number: ");
		num = keyboard.nextInt();
		trash = keyboard.nextLine();
		System.out.print("Product name: ");
		name = keyboard.nextLine();
		System.out.print("Product Price: ");
		price = keyboard.nextDouble();
		for(Product p : product)
		{
			if(p.getProductNum() == num){
				System.out.println("Input Error: Product " + num
				+" already exists.");
				return false;
			}
		}
		product.add(new Product(num,name,price));
		System.out.format("Product Added - %s, No: %d, Price: %.2f \n",name,num,price );
		return true;
	}
	boolean deleteProduct()
	{
		int num;
		int index = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Product Number To Delete: ");
		num = keyboard.nextInt();
		for(Product p : product)
		{
			if(p.getProductNum() == num)
			{
				product.remove(index);
				System.out.format("Product %d deleted \n",num);
			
				return true;
			}
			index++;
		}
		System.out.println("Input Error: " + num +" doesn't exis.t");
		return false;
	}
	public void productInfo(){
		Scanner keyboard = new Scanner(System.in);
		String input;
		int productNum = 0;
		int i =1;
		System.out.print("Enter product number(Enter for all products): ");
		input = keyboard.nextLine();
		if(input.length() >= 1)
			productNum = Integer.parseInt(input);
		if(input.length() == 0)
		{
			for(Product p : product)
			{
				System.out.format("%d. %s (No. %d): %.2f \n",i,p.getProductName(),p.getProductNum(),p.getUnitPrice());
				i++;
			}
			return;
		}
		else
		{
			for(Product p : product)
			{
				if( productNum == p.getProductNum())
				{
					System.out.format("No. %d: %s, %.2f",p.getProductNum(),p.getProductName(),p.getUnitPrice());
					return;
				}
			}
		}
		
	}
 	public static void main(String[] args) {
 		 Scanner sc = new Scanner (System.in);
 		 OnlineStore csumbOnlineStore = new OnlineStore("CSUMB");
 		 int option;
 		 System.out.println("Welcome to CSUMB OnlineStore");

 		 do
 		 {
 			 System.out.println("Select your choice:");
 			 System.out.println(" 1. Add Product");
 			 System.out.println(" 2. Delete Product"); 
 			 System.out.println(" 3. Product Info"); 
 			 System.out.println(" 4. Make Order");
 			 System.out.println(" 5. Update Product");
 			 System.out.println(" 6. Exit"); 
 			 option = sc.nextInt();

 			 if (option == 1)
 			 {	
 				 csumbOnlineStore.addProduct();
 			 }
 			 else if (option == 2)
 			 {
 				csumbOnlineStore.deleteProduct();
 			 } 
 			 else if (option == 3)
 			 {
 				csumbOnlineStore.productInfo();
 			 } 
 			 else if (option == 4)
 			 {
 			 csumbOnlineStore.makeOrder();
 			 }  
 			 else if (option == 5)
 			 {
 			 csumbOnlineStore.updateProduct();
 			 }
 			 else if (option == 6)
 			 {
 				 System.out.println("Bye");
 			 return;
 			 }
 			 else
 			 {
 				 System.out.println("Incorrect option");
 			 } 
 			 System.out.println("\n\n"); 
 		 }while(true);

	}

}
