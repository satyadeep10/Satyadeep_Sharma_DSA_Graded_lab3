package com.gl.graded2week7.dsa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;	

public class PairBinarySearchTree 
{

	private static Scanner sc;


	class Node 
	{
		public int Nodedata;
		public Node left;
        public Node right;
	}
	
	public Node newNode(int data) 
	{
		Node temp=new Node();
		temp.Nodedata=data;
		temp.left=null;
		temp.right=null;
		
		return temp;	
	}
	
	public Node insertNodeData(Node root,int key) 
	{
		Node newnode=newNode(key);
		Node x=root;
		Node current_parent=null;
		
		
		while(x!=null) 
		{
			current_parent=x;
			if (key < x.Nodedata)
				{
				x = x.left;
				}
			else if (key > x.Nodedata)
				{
				x = x.right;
				}
			else 
			
			{
			System.out.println("Value already exists!!!");
			return newnode;
			}
		}
		
		if(current_parent==null) 
		{
			current_parent=newnode;
			
			return current_parent;
		}
		
		else if(key<current_parent.Nodedata) 
		{
			current_parent.left=newnode;
		}
		else 
		{
			current_parent.right=newnode;	
		}
		
		return root;
	
		
	}
	
	public static boolean findPair(Node root, int sum, Set<Integer> set) 
	{
		
		if(root == null)
		{
		return false;
		}
		if(findPair(root.left,sum,set))
		{
			return true;
		}
		
		if(set.contains(sum-root.Nodedata)) 
		{
			System.out.println("Pair Found: "+ root.Nodedata + " -- "+ (sum-root.Nodedata));
			return true;
		}
		
		else 
		{
			set.add(root.Nodedata);
		}
		return findPair(root.right,sum,set);		
		
	}
	
	public static void main(String[] args) 
	{
	    Node root=null;
		System.out.println("Enter binary search tree size:");
		sc = new Scanner(System.in);
		int size=sc.nextInt();
	    PairBinarySearchTree pbst = new PairBinarySearchTree();
	    
	    System.out.println("Enter tree elements");
	    for(int i=1;i<=size;i++)
	    {
	    System.out.println("Element "+ i);
	    int value =sc.nextInt();
		root= pbst.insertNodeData(root,value);
	    }
		
	    System.out.println("Enter sum for which Pair to be found: ");
	    int sum=sc.nextInt();
	    
	    Set<Integer> set = new HashSet<>();
	    
	    if (!findPair(root, sum, set)) {
            System.out.println("Pair does not exist");
        }

	    
	}
}
