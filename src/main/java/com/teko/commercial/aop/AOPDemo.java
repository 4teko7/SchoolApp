package com.teko.commercial.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Aspect
@Component
public class AOPDemo {

	
	// this is where we add all of our related advices for logging
	
	//@Before Advide
	
//	@Before("execution(public String com.teko.commercial.controllers.HomeController.root())")
	@Before("execution(* root*(..))")
	public void beforeHomeAdvice() {
		System.out.println("BEFORE HOME WAS EXECUTED !");
	}
	
}
