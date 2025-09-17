package aop.demo.Aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

	@Pointcut("within(aop.demo.Aop..*)")
	public void authenticatingPointcut() {
		
	}
	
	@Pointcut("within(aop.demo.Aop.ShoppingCart.*)")
	public void authorizationPointcut() {
		
	}
	
	@Before("authenticatingPointcut() && authorizationPointcut()")
	public void authenticate() {
		System.out.println("Authenticating request");
	}
}
