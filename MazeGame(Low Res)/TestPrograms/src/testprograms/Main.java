package testprograms;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a, b, x;
		a = input.nextInt();
		//input.nextLine();
		b = input.nextInt();
		//input.nextLine();
		x = a + b;
		System.out.println("x = " + x);
	}
}
