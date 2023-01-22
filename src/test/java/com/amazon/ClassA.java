package com.amazon;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ClassA {
	public static ClassA a = null;
	
	public static ClassA getInstance() {
	
		if(a==null) {
			a = new ClassA();
		}
		return a;
	}
	
	private ClassA() {
	}
	
public static void main(String[] args) {
}



}
