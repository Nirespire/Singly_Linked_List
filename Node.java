/*
Author: Sanjay Nair
UFID: 
COP3503
Project 5
*/

public class Node<T>{
	public T data;
	public Node<T> next;
	
	public Node(){
		data = null;
		next = null;
	}
	
	public Node(T data){
		this.data = data;
		next = null;
	}
	
	public Node(T data, Node<T>next){
		this.data = data;
		this.next = next;
	}
	
	public String toString(){
		String output = null;
		
		if(data != null){
			output = data.toString();
		}
		
		return output;
	}
}