package com.surya;

 abstract class A {
	public void m1(int x) {
		System.out.println("B");
	}
	public abstract void m2();

	
}
public class Demoooooo extends A {
	public void m3() {
		System.out.println("m3");
	}

	public static void main(String[] args) {
		
		A a=new A() {

			@Override
			public void m2() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}
	
	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

}
