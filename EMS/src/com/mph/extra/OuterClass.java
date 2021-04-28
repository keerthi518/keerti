package com.mph.extra;

public class OuterClass {

	static int x = 700;
	static class InnerClass
	{
		int y=155;
		public void sInnerMethod()
		{
			System.out.println("x in inner method : " + x + " " + y);
		}
		
	}
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass sic = new OuterClass.InnerClass(); 
		sic.sInnerMethod();
	}

}