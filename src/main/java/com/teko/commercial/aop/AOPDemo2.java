package com.teko.commercial.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.teko.commercial.encryption.EncodeDecode;

@Aspect
@Component
@Order(1)
public class AOPDemo2 {

	@Pointcut("execution(* root*(..)))")
	private void forRoot() {}
	
	@Pointcut("execution(* home*(..)))")
	private void forHome() {}
	
	@Pointcut("execution(* registerUser*(..)))")
	private void forAddUser() {}
	
	
	
	
	@Pointcut("forRoot() || forHome() || forAddUser()")  //This is okay when anyone of then is called, then this pointcut will be active
	
//	@Pointcut("forRoot() & !(forHome() || forAddUser())")  // This works only at root page.
	private void forRootHomeAndAddUser() {}
	
//	@Before("forRootHomeAndAddUser()")
	public void beforeHomeAdvice() {

		System.out.println("BEFORE FROM AOPDEMO 2");
	}
	
}
