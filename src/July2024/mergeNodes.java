package July2024;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class mergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead=new ListNode(0);
        ListNode currNode=head.next;
        ListNode dummy=newHead;
        int sum=0;
        while(currNode!=null){
            if(currNode.val!=0){
                sum+=currNode.val;
            }
            if(currNode.val==0){
                dummy.next=new ListNode(sum);
                dummy=dummy.next;
                sum=0;
            }
            currNode=currNode.next;
        }
        return newHead.next;
    }
}
