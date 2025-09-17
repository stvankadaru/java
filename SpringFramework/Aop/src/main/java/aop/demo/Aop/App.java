package aop.demo.Aop;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.springcore.javabasedconfig.BeanConfig;


public class App{
	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext (BeanConfig.class);
		ShoppingCart cart= context.getBean (ShoppingCart.class);
		cart.checkout ("checkout started");
	}
}