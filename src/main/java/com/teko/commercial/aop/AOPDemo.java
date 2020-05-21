package com.teko.commercial.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teko.commercial.encryption.EncodeDecode;

@Aspect
@Component
@Order(2)
@RestController
public class AOPDemo {

	
	// this is where we add all of our related advices for logging
	
	//@Before Advide
	

//	@Before("execution(* root*(..))") //this okay

	
//	@Before("execution(public String com.teko.commercial.controllers.HomeController.root(..))")  /this is okay
	
//	@Before("execution(public String com.teko.commercial.controllers.HomeController.root(..,org.springframework.ui.Model))") //This is for parameters
	
//	@Before("execution(public String com.teko.commercial.controllers.HomeController.root(boolean,org.springframework.ui.Model))") //This works also.
	
	
//	@Pointcut("execution(public String com.teko.commercial.controllers.HomeController.root(boolean,org.springframework.ui.Model))")
	
	
	@Pointcut("execution(* root*(..)))")
	private void forRoot() {}
	
	@Pointcut("execution(* home*(..)))")
	private void forHome() {}
	
	@Pointcut("execution(* registerUser*(..)))")
	private void forAddUser() {}
	

	
	
	@Pointcut("forRoot() || forHome() || forAddUser()") // This is okay when anyone of then is called, then this pointcut will be active
	
//	@Pointcut("forRoot() & !(forHome() || forAddUser())")  // This works only at root page.
	private void forRootHomeAndAddUser() {}
	
//	@Before("forRootHomeAndAddUser()")
//	public void beforeHomeAdvice(JoinPoint jPoint) {
//		System.out.println((MethodSignature) jPoint.getSignature()); // String com.teko.commercial.controllers.HomeController.root(boolean,Model)
//		System.out.println("ARGS: " + jPoint.getArgs());
//		Object[] args = jPoint.getArgs();
//		for (Object arg : args) {
//			System.out.println("Argument : " + arg); // Give you all arguments in the url
//		}
//		System.out.println("BEFORE FROM AOPDEMO 1");
//	}
	
	
	@AfterReturning(pointcut = "forRootHomeAndAddUser()",returning = "result")
	public String beforeHomeAdvice(JoinPoint jPoint,Object result) {
//		System.out.println((MethodSignature) jPoint.getSignature()); // String com.teko.commercial.controllers.HomeController.root(boolean,Model)
//		System.out.println("ARGS: " + jPoint.getArgs());
//		Object[] args = jPoint.getArgs();
//		for (Object arg : args) {
//			System.out.println("Argument : " + arg); // Give you all arguments in the url
//		}
//		System.out.println("BEFORE FROM AOPDEMO 1");
		System.out.println(result);
		return "Hello";
	}
	
//	@Before("forRootPointCut()")
//	public void sayHello() {
//		System.out.println("HELLO FROM SAY HELLO2");
//	}
	
}
