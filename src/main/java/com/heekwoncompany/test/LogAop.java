package com.heekwoncompany.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
//	@Pointcut("within(com.heekwoncompany.test.*)") //모든 클래스 실행
	@Pointcut("within(com.heekwoncompany.test.Soldier)") //Soldier 클래스만 실행
	private void pointcutMethod() {
		
	}
	
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		//공통기능 분리
		String signatureStr = joinpoint.getSignature().toString();
		
		System.out.println(signatureStr+"메서드가 시작됨!!!");
		System.out.println("**자기소개하기**"); // 공통기능
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			System.out.println(signatureStr+"메서드가 종료됨!!!");
		}
	}
	
}
