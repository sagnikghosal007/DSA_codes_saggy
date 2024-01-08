class GFG
{
    /*Node reverse(Node head)
    {
        Node nextnode=head;
        Node currnode=head;
        Node prevnode=null;
        while(nextnode!=null)
        {
            nextnode=currnode.next;
            currnode.next=prevnode;
            prevnode=currnode;
            currnode=nextnode;
        }
        head=prevnode;
        return head;
    }
    Node mergeResult(Node node1, Node node2)
    {
	// Your code here
	Node ptr1=reverse(node1);
	Node ptr2=reverse(node2);
	Node head=new Node(-1);
     Node dummynode=head;
	while(ptr1!=null && ptr2!=null)
	{
	    if(ptr1.data<ptr2.data)
	{
	    Node newNode =new Node(ptr1.data);
	    ptr3.next=newNode;
	    ptr1=ptr1.next;
	    ptr3=ptr3.next;
	}
	else if(ptr1.data>ptr2.data)
	{
	    Node newNode =new Node(ptr2.data);
	    ptr3.next=newNode;
	    ptr2=ptr2.next;
	    ptr3=ptr3.next;
	}
	}
	while(ptr1!=null)
	{
	    Node newNode =new Node(ptr1.data);
	    ptr3.next=newNode;
	    ptr1=ptr1.next;
	    ptr3=ptr3.next;
	}
	while(ptr2!=null)
	{
	    Node newNode =new Node(ptr2.data);
	    ptr3.next=newNode;
	    ptr2=ptr2.next;
	    ptr3=ptr3.next;
	}
	return dummynode.next;*/
	Node mergeResult(Node node1, Node node2)
    {
	if(node1==null && node2==null) {
            return null;
        }
        
        Node curr = null;
        
        while(node1!=null || node2!=null) {
            if(node1==null) {
                Node temp = new Node(node2.data);
                temp.next = curr;
                curr = temp;
                node2 = node2.next;
            } else if(node2==null) {
                Node temp = new Node(node1.data);
                temp.next = curr;
                curr = temp;
                node1 = node1.next;
            } else if(node1.data > node2.data) {
                Node temp = new Node(node2.data);
                temp.next = curr;
                curr = temp;
                node2 = node2.next;
            } else {
                Node temp = new Node(node1.data);
                temp.next = curr;
                curr = temp;
                node1 = node1.next;
            }
        }
        

        
        return curr;
    }
}
