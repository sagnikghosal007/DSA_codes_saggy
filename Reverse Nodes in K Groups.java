class Solution {

    // Helper function to reverse a segment of k nodes
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // Reverse the first k nodes in the segment
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check if there are at least k nodes remaining
            ListNode start = prev.next;
            ListNode end = curr;
            int count = 0;

            // Move end pointer to the end of the current k-group
            while (end != null && count < k) {
                end = end.next;
                count++;
            }

            // If we have exactly k nodes, reverse the current k-group
            if (count == k) {
                ListNode nextSegmentStart = end; // Save the start of the next segment
                ListNode reversedSegmentStart = reverseKNodes(start, k); // Reverse the current k-group

                // Connect the reversed segment back into the list
                prev.next = reversedSegmentStart;
                start.next = nextSegmentStart;

                // Update prev and curr pointers for the next iteration
                prev = start;
                curr = nextSegmentStart;
            } else {
                // If there are fewer than k nodes remaining, break out of the loop
                break;
            }
        }

        return dummy.next; // Return the head of the modified list
    }
}




// most importantly striver's solution 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  //normal 4 step reverse Linked List function likhlam 
    public ListNode reverseLL(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return head;
    }
  //simple kth node ta peye jabo by traversing from the start 
    public ListNode getKNode(ListNode temp, int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
  // main kaaj ekhane hobe , go and watch strivers video if you can't understand the code 
  // I made the code as readable as posssible in Java 
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;
        while(temp!=null){
            ListNode kthNode=getKNode(temp,k);
            if(kthNode==null){
                if(prevLast!=null) prevLast.next=temp;
                break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverseLL(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevLast.next=kthNode;
            }
            prevLast=temp;
            temp=nextNode;

        }
        return head;
    }
   
}
