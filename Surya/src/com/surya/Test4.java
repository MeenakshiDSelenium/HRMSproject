package com.surya;

public class Test4 implements Test1,Demo {

	public void m4() {
		System.out.println("meena");	
		
	}
	public void m5() {
		System.out.println("obu");	
		}
	public void m1() {
		System.out.println("surya");
		}
	public void m2() {
		System.out.println("obulesu");	
		}
	public void m3() {
	System.out.println("meenakshi");
		}
	public static void main(String[] args) {
		Test4 t=new Test4();
		
		t.m1();
		t.m2();
		t.m3();
		t.m4();
		t.m5();
	}

}
