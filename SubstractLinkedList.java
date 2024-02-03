
//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
       static int getLen(Node node){
        int count = 0;
        while(node!=null){
            node = node.next;
            count++;
        }
        return count;
    }
    
    static boolean isLarger(Node l1, Node l2){
        int s1 = getLen(l1), s2 = getLen(l2);
        
        if(s1 > s2){
            return true;
        }else if(s2 > s1){
            return false;
        }
        
        Node c1 = l1, c2 = l2;
        
        while(c1 != null){
            if(c1.data > c2.data){
                return true;
            }else if(c2.data > c1.data){
                return false;
            }
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return true;
    }
    
    static Node reverse(Node node){
        Node prev = null, curr = node;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    static Node removeZeros(Node head){
        Node curr = head;
        while(curr!=null && curr.data == 0){
            curr = curr.next;
        }
        return curr;
    }
    
    static Node subtract(Node l1, Node l2){
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        Node dummy = new Node(-1);
        Node c1 = l1, c2 = l2, prev = dummy;
        
        int borrow = 0;
        
        while(c1 != null){
            int sub = c1.data - (c2!=null? c2.data: 0) + borrow;
            
            if(sub < 0){
                sub+= 10;
                borrow = -1;
            }else{
                borrow = 0;
            }
            
            prev.next = new Node(sub);
            prev = prev.next;
            c1 = c1.next;
            if(c2!=null){
                c2 = c2.next;
            }
        }
        
        Node head = dummy.next;
        dummy.next = null;
        head = reverse(head);
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        head = removeZeros(head);
        return head == null? new Node(0): head;
    }
    
    static Node subLinkedList(Node l1, Node l2)
    {
        
        l1 = removeZeros(l1);
        l2 = removeZeros(l2);
        
        boolean check = isLarger(l1, l2);
        Node c1 = check? l1: l2; 
        Node c2 = check? l2: l1;
        
        return subtract(c1, c2);
    }
}
