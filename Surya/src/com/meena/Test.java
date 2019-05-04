package com.meena;

class Prob1{
int puzzel(int n){
int result;
if (n==1)
return 1;
result = puzzel(n-1) * n;
return result;
}
}


public class Test {

	public static void main(String[] args) {
		Prob1 f = new Prob1();
		System.out.println(" puzzel of 6 is = " + f.puzzel(6));


	}

}
