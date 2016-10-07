/* package whatever; // don't place package name! */

import java.io.*;

class Node
{
    String data;
    Node next;
    
    public Node (String newData) {
        this.next = null;
        this.data = newData;
    }
}

class Stack
{
    private Node top;
    
    public Stack() {
        this.top = null;
    }
    
    public String pop() {
        if (this.top == null) {
            return "EMPTY STACK";
        } else {
            String retData = top.data;
            top = top.next;
            return retData;
        }
    }
    
    public void push(String data) {
        if (top == null) {
            this.top = new Node(data);
        }else {
            Node newTop = new Node(data);
            newTop.next = this.top;
            this.top = newTop;
        }
        
    }
    
    public String peek() {
        if (this.top == null) {
            return "EMPTY STACK";
        } else {
            return this.top.data;
        }
    }
}
    
    
class myCode
{ 
    
    public static void main (String[] args) throws java.lang.Exception
    {
        String b = "hello";
        String c = "elle";
        String d = "abacaba";
        String e = "aaaaaaaaaaaaaaaaaaaaaa";        
        String a = c;
        
        Stack myStack = new Stack();
        // myStack.push("o");
        // myStack.push("n");
        // myStack.push("e");
        // String.charAt()
        int moreNum = 0;
        if (a.length() % 2 == 1) {
            moreNum = 1;
        }
        
        for(int i = 0; i < a.length()/2; i++){
            myStack.push(Character.toString(a.charAt(i)));
        }        
            
        Boolean isPal = true;
        for (int j = a.length()/2 + moreNum; j<a.length(); j++){
            if (!(myStack.pop().equals(Character.toString(a.charAt(j))))) {
                isPal = false;
            }
        }
        
        System.out.println(isPal);
        
        //while(!(myStack.peek().equals("EMPTY STACK"))) {
        //    System.out.println(myStack.pop());
        //}
    }
}
