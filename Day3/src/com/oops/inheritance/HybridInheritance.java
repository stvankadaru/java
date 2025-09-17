package com.oops.inheritance;


class Cloth extends Product implements IDiscountable {

	public Cloth(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscount() {
		return price*0.18;
	}
	public void show() {
		System.out.println("Name: "+name+" Price: "+price+" Discount: "+getDiscount());
	}
	
}
public class HybridInheritance {
	public static void main(String[] args) {
		Cloth c=new Cloth("Jeans", 2456);
		c.show();
	}
}
