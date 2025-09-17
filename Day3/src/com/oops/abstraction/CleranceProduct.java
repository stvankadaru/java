package com.oops.abstraction;

public class CleranceProduct implements Discountable{
	
	private String name;
	private double price;
	
	public CleranceProduct(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public double calculateDiscount() {
		// TODO Auto-generated method stub
		return price*0.50;
	}
	
	public void show()
	{
		
		System.out.printf("Clearance : %s | Price: Rs. %.2f | Discount: Rs. %.2f%n" ,name,price,calculateDiscount());  
	}
	
	
}
