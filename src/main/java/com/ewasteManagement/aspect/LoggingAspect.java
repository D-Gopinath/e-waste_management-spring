package com.ewasteManagement.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Around("execution (* com.ewasteManagement.controller.UserController+.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logaround is running");
		System.out.println("Method name:"+ joinPoint.getSignature().getName());
		System.out.println("Method parameters:"+Arrays.toString(joinPoint.getArgs()));
		Object object = joinPoint.proceed();
		System.out.println("logaround is completed");
		return object;
	}
	
	@Around("execution (* com.ewasteManagement.controller.FacilityController+.*(..))")
	public Object logAround1(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logaround is running");
		System.out.println("Method name:"+ joinPoint.getSignature().getName());
		System.out.println("Method parameters:"+Arrays.toString(joinPoint.getArgs()));
		Object object = joinPoint.proceed();
		System.out.println("logaround is completed");
		return object;
	}

}
