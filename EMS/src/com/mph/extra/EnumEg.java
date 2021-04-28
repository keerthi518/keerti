package com.mph.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum color
{
	RED,BLUE,GREEN;
}

public class EnumEg {

	public static final int RED =1;
	public static final int BLUE =2;
	public static final int GREEN =3;
	public static void main(String[] args) throws IOException {
		
		for(color c : color.values())
		{
			System.out.println(c);
			System.out.println(c.ordinal());
			
		}
		
		color choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your choice");
		choice = color.valueOf(br.readLine());
		
		switch(choice) {
		case RED:
		{
			System.out.println("Red color");
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