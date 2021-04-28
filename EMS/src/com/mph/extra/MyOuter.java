package com.mph.extra;

public class MyOuter {

	private int x=100;
	public void OuterMethod()
	{
		System.out.println("x in outer method : " + x);
		MyInner mii = new MyInner();
		mii.InnerMethod();
	}
	
	class MyInner
	{
		public void InnerMethod()
		{
			System.out.println("x in inner method : " + x);
		}
		
	}
	
	
	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		mo.OuterMethod();
		
		MyOuter.MyInner mi = mo.new MyInner();
		mi.InnerMethod();
		
		}

}