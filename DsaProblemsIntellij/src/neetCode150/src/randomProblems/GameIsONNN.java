package randomProblems;

import java.util.Scanner;

public class GameIsONNN 
{
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Kripya 5 Dabaye-->>");
	int n=sc.nextInt();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(j==2 || i==j && j>=n/2+1 ||(i==3&&j==2)|| (i+j==n+1 && j>=n/2+1))
			  System.out.print("$$");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(i==1 || j==1 || j==n || i==n/2+1)
			  System.out.print("@@");
		else
			System.out.print("  ");
		
	}
		System.out.println();
		
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(j==1 || i==1 || i==3 || (j==5 && i+j!=9 && i!=j)|| (i==4 && j==3) || (i==5&&j==4) )
			  System.out.print("%%");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(i==5 || i==1 || j==3)
			  System.out.print("!!");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(i==1 || i==5 || i==3 || (i==2 && j==1) || (i==4 && j==5))
			  System.out.print("$$");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(j==1 || j==5 || i==3)
			  System.out.print("##");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(j==1 || j==5 || (i==1 && j==1 || i==2 && j==2)||(i==3&&j==3)||(i==2&&j==4)|| (i==4&&j==3))
			  System.out.print("()");
		else
			System.out.print("  ");
		
	}
		System.out.println();
}
	System.out.println();
	for (int i = 1; i <= n; i++) 
	{
		for (int j=1; j<=n; j++) 
		{
		  if(i==1 || j==1 || j==n || i==n/2+1)
			  System.out.print("@@");
		else
			System.out.print("  ");
		
	}
		System.out.println();
		
}
	System.out.println("                     How was it?");
}
}