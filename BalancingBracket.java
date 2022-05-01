package com.gl.graded2week7.dsa;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket 
{

	Stack<Character> stack = new Stack<>();
	public static String str;
	boolean unbalanced=false;
	
	//Method to check the balancing or unbalancing of String with brackets
	public void balancingBracket() 
	{
		System.out.println("Enter String to check balancing bracket");
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		breakFor:
		for(int i=0;i<str.length();i++) 
		{
			char ch=str.charAt(i);
			
			
			switch(ch) 
			{
			case '(':
			case '[':
			case '{':
				stack.push(ch);
				continue;
				
			case ')':
			    if(stack.empty()) 
			    {
			    	unbalanced=true;
			    	break breakFor;
			    }
			    else if(!stack.empty())
			    {
			    	char ch2=stack.pop();
			    	if(ch2!= '(') 
			    	{
			    	    unbalanced = true;
			    		break breakFor;
			    	}	
			    } continue;
			case '}':
			    if(stack.empty()) 
			    {
			    	unbalanced=true;
			    	break breakFor;
			    }
			    else if(!stack.empty())
			    {
			    	char ch2=stack.pop();
			    	if(ch2!= '{') 
			    	{
			    	    unbalanced = true;
			    		break breakFor;
			    	}
			} continue;
			case ']':
			    if(stack.empty()) 
			    {
			    	unbalanced=true;
			    	break breakFor;
			    }
			    else if(!stack.empty())
			    {
			    	char ch2=stack.pop();
			    	if(ch2!= '[') 
			    	{
			    	    unbalanced = true;
			    		break breakFor;
			    	}
			    } continue;
			    
//			 case ('!') OR ('@'):
//			      System.out.println("Entered values are not correct");
//			      break;
//				
			    }
			}
		if(unbalanced) 
		{
			System.out.println("\n"+"String in unbalanced");
		}
		else 
		{
			System.out.println("\n"+"String in balanced");
		}
		
	}
	
	
	public static void main(String[] args) 
	{
	
		BalancingBracket bb= new BalancingBracket();
		bb.balancingBracket();
		
		
	}
	
	
}
