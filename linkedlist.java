/* package whatever; // don't place package name! */

import java.io.*;

class node{
    String data = null;
    node next = null;
    
    public node(String newData) {
        this.data = newData;
    }
}

class linkedList {
    node head;
    
    public linkedList(node head) {
        this.head = head;
    }
    
    public void newNode(String newData) {
        node tempHead = head;
        while(tempHead.next != null) {
            tempHead = tempHead.next;
        }
        node temp = new node(newData);
        tempHead.next = temp;
    }
    
    public String removeAllNodes(String removeStr) {
        node tempHead = this.head;
        node prev = null;
        
        if (tempHead == null) {
            return "No List";
        } 
        
        while(tempHead != null) {
            if (removeStr.equals(tempHead.data)) {
                if (prev == null) {
                    tempHead = tempHead.next;
                    this.head = tempHead;
                } else {
                    prev.next = tempHead.next;
                    tempHead = tempHead.next;
                }
            } else {
                prev = tempHead;
                tempHead = tempHead.next;
            }
        }
        return removeStr;
    }
    
    public void printNodes() {
        node curr = this.head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    
    
}


class myCode
{   
        
    public static node removeAllNodesTest(node head, String removeStr) {
        node tempHead = head;
        node newHead = head;
        node prev = null;
        
        if (tempHead == null) {
            return null;
        }
        
        while (tempHead != null) {
            if (removeStr.equals(tempHead.data)) {
                if (prev == null) {
                    tempHead = tempHead.next;
                    newHead = tempHead;
                } else {
                    prev.next = tempHead.next;
                    tempHead = tempHead.next;
                }
            } else {
                prev = tempHead;
                tempHead = tempHead.next;
            }
            
        }
        
        return newHead;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        
        
        
        node head = new node("A");
        
        linkedList myList = new linkedList(head);
        
        myList.newNode("B");
        myList.newNode("A");
        myList.newNode("B");
        myList.newNode("X");
        
        
        
        //removeAllNodes("B");
        
        
        
        linkedList newMyList = new linkedList(removeAllNodesTest(myList.head, "A"));
        
        
        myList.printNodes();
    }
}

