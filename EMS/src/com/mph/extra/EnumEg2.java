package com.mph.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnumEg2 {

	
	enum color{
		RED(100),BLUE(12),GREEN(15);

		private int val;

		color(int value) {
			this.val=value;
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		for(color s : color.values())
		{
			System.out.println(s+ "  " + s.val);
		}
		
		color choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your choice");
		choice = color.valueOf(br.readLine());
		
		switch(choice) {
		case RED:
		{
			System.out.println("Red color value is  " + choice.val);
			break;
		}
		case BLUE:
		{
			System.out.println("Blue color");
			break;
		}
		case GREEN:
		{
			System.out.println("Green color");
			break;
		}
		default:
		{
			System.out.println("No color :(");
		}
		}
		

	}

}