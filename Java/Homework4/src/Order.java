/*
 * Title:Order.java
 * Abstract: Is used to handle storing an order of a store and how many items with cost.
 * Name:Daniel Calderon
 * Date: 2 /26/17
 * ID: 3083
 */
import java.util.ArrayList;

public class Order {
	Order(int num)
	{
		this.orderNum = num;
	}
	private int orderNum;
	private double totalPrice;
	private ArrayList<Product> items = new  ArrayList<Product> ();
	public void getItems()
	{
		int i= 1;
		for(Product p: items)
		{
			System.out.format("		Item %d: %s (No. %d): $ %.2f \n",i,p.getProductName(),p.getProductNum(),p.getUnitPrice());
			i++;
		}
	}
	public void addItem(int num, String name, double d)
	{
		items.add(new Product(num,name,d));
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice += totalPrice;
	}
	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
