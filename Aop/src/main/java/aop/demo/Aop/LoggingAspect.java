package aop.demo.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* aop.demo.Aop.ShoppingCart.checkOut(..))")
	public void beforeLogger(JoinPoint jb) {
//		System.out.println();
		System.out.println("Before Loggers");
	}
	
	@Around("execution(* aop.demo.Aop.*.checkOut(..))")
	public void aroundLogger(JoinPoint jb) {
		String arg = jb.getArgs()[0].toString();
		System.out.println(arg);
	}
	
//	@AfterReturning(pointcut="execution(* *..*.checkout(..))", returning = "returnString")
//	public void getNameReturningAdvice(String returnString) {
//		System.out.println("getNameReturningAdvice executed Returned string = "+returnString);
//	}
	
	@AfterThrowing(pointcut="execution(* aop.demo.Aop.*.checkOut(..))",throwing="ex")
    public void handleException(Throwable ex) {
        System.out.println("After Throwing -Exception: "+ex.getMessage());
    }
//	
	@AfterReturning(pointcut="execution(* aop.demo.Aop.*.checkOut(..))",returning="retVal")
    public void doAfterReturningTask(Object retVal) {
        System.out.println("After Returning -returned value: "+retVal);
    }
}


