/*
Author: Sanjay Nair
UFID: 
COP3503
Project 5
*/

/*
Singly linked list. Includes head and tail variables with each node
having a next property
*/

public class SLL<T>{
	public Node<T> head;
	public Node<T> tail;
	
	public SLL(){
		head = null;
		tail = null;
	}
	
	public SLL(T data){
		Node<T> node1 = new Node<T>(data);
		
		head = node1;
		tail = node1;
	}
	
	public SLL(Node<T> node){
		head = node;
		tail = node;
	}
	
	public SLL(Node<T> head, Node<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	public boolean isEmpty(){
		boolean output = false;
		
		if(this.head == null && this.tail == null){
			output = true;
		}
		
		return output;
	}
	
	// Add element to the end of the list
	public void append(T data){
		Node<T> temp = new Node<T>(data);
		
		if(this.isEmpty()){
			this.head = temp;
			this.tail = temp;
		}
		
		else{
			this.tail.next = temp;
			this.tail = temp;
		}
		
	}
	
	// Add element to the beginning of the list
	public void prepend(T data){
		Node<T> temp = new Node<T>(data);
		
		if(this.isEmpty()){
			this.head = temp;
			this.tail = temp;
		}
		
		else{
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	public boolean insert(T data, int index){
		boolean output = false;
		int count = 0;
		Node<T> current = this.head;
		Node<T> beforeCurrent = null;
		Node<T> temp = new Node<T>(data);
		
		//If the index is exactly at the beginning of the list (handles cases where list is empty)
		if(index == 0){
			this.prepend(data);
			output = true;
		}
		
		//If the list is empty
		else if(current == null){
			this.head = temp;
			this.tail = temp;
			output = true;
		}
		
		while(count < index){
			count++;
			beforeCurrent = current;
			
			//If the index is beyond the end of the tail of the list
			if(current.equals(this.tail) && count + 1 < index){
				current = null;
				beforeCurrent = null;
				count++;
				break;
			}
			
			current = current.next;
			
			//If the index is entirely outside the bounds of the list
			if(current == null){
				break;
			}
			
		}
		
		//If the index is exactly at the end of the list
		if(count == index && current == null && beforeCurrent != null){
			this.append(data);
			output = true;
		}
		
		//If the index is anywhere in bewteen the head and tail of the list
		else if(count == index && current.next != null && beforeCurrent != null){
			beforeCurrent.next = temp;
			temp.next = current;
			output = true;
		}
		
		//If the index is outside the bounds of the list
		else if(current == null && beforeCurrent == null){
			output = false;
		}
		
		
		return output;
	}
	
	// Find by data in Node
	public Node<T> get(T data){
		Node<T> output = null;
		Node<T> current = this.head;
		
		while(current != null){
		
			if(current.data.equals(data)){
				output = current;
				break;
			}
			
			current = current.next;
		}
		
		return output;
	}
	
	// Find by index of Node
	public Node<T> get(int index){
		Node<T> output = null;
		Node<T> current = this.head;
		int count = 0;
		
		while(count <= index){
			if(current == null){
				output = null;
				break;
			}
			
			else if(count == index){
				output = current;
				break;
			}
			
			current = current.next;
			
			count++;
		}
		
		return output;
	}
	
	// Return index of Node with matching data
	public int indexOf(T data){
		int output = -1;
		int count = 0;
		Node<T> current = this.head;
		
		while(current != null){
		
			if(current.data.equals(data)){
				output = count;
			}
			
			current = current.next;
			count++;
		}
		
		return output;
	}
	
	// Return index of Node with matching data of input Node
	public int indexOf(Node<T> node){
		int output = -1;
		Node<T> current = this.head;
		int count = 0;
		
		while(current != null){
		
			if(current.data.equals(node.data)){
				output = count;
				break;
			}
			
			current = current.next;
			count++;
		}
		
		return output;
		
	}
	
	// Remove by matching data in Node
	public boolean remove(T data){
		boolean output = false;
		Node<T> current = this.head;
		Node<T> beforeCurrent = null;
		
		//If list is not empty
		while(current != null){
			if(current.data.equals(data)){
			
				//If item is sole element in list
				if(beforeCurrent == null && current.next == null){
					this.head = null;
					this.tail = null;
					output = true;
					break;
				}
				
				//If item is head of list
				else if(beforeCurrent == null){
					this.head = current.next;
					output = true;
					break;
				}
				
				//If item is tail of list
				else if(current.next == null){
					beforeCurrent.next = null;
					this.tail = beforeCurrent;
					output = true;
					break;
				}
				
				//If item is anywhere between head and tail (size > 2)
				beforeCurrent.next = current.next;
				output = true;
				break;
			}
			
			beforeCurrent = current;
			if(current.next == null){
				break;
			}
			current = current.next;
		}
		
		return output;
	}
	
	// Remove by matching data of input Node
	public boolean remove(Node<T> node){
		boolean output = false;
		Node<T> current = this.head;
		Node<T> beforeCurrent = null;
		
		while(current != null){
			if(current.data.equals(node.data)){
			
				if(beforeCurrent == null && current.next == null){
					this.head = null;
					this.tail = null;
					output = true;
					break;
				}
				
				else if(beforeCurrent == null){
					this.head = current.next;
					output = true;
					break;
				}
				
				else if(current.next == null){
					beforeCurrent.next = null;
					this.tail = beforeCurrent;
					output = true;
					break;
				}
				
				
				beforeCurrent.next = current.next;
				output = true;
				break;
			}
			
			beforeCurrent = current;
			
			if(current.next == null){
				break;
			}
			current = current.next;
		}
		
		return output;
	}
	
	// Remove by index
	public boolean remove(int index){
		boolean output = false;
		Node<T> current = this.head;
		Node<T> beforeCurrent = null;
		int count = 0;
		
		while(count <= index && current != null){
			if(count == index){
			
				if(beforeCurrent == null && current.next == null){
					this.head = null;
					this.tail = null;
					output = true;
					break;
				}
			
				else if(beforeCurrent == null){
					this.head = current.next;
					output = true;
					break;
				}
				
				else if(current.next == null){
					beforeCurrent.next = null;
					this.tail = beforeCurrent;
					output = true;
					break;
				}
				
				beforeCurrent.next = current.next;
				output = true;
				break;
			}
			
			beforeCurrent = current;
			
			if(current.next == null){
				break;
			}
			current = current.next;
			
			count++;
		}
		
		return output;
	}
	
	public int size(){
		int count = 0;
		Node<T> current = this.head;
		
		while(current != null){
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	
	// Garbage collector clears unreferenced Nodes
	public void clear(){
		this.head = null;
		this.tail = null;
	}
}