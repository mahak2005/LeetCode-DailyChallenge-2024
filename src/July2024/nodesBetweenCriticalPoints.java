package July2024;
import java.util.ArrayList;
import java.util.List;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class nodesBetweenCriticalPoints {


    //-> TC-> O(n) , SC->O(1)
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        int min = Integer.MAX_VALUE;
        int max = -1;
        int index = 0;
        int first = -1;
        int last = -1;
        int previ = -1;
        while (current.next != null) {
            if ((prev.val > current.val && current.val < current.next.val) || (prev.val < current.val && current.val > current.next.val)) {
                if (previ == -1) {
                    first = index;
                    previ = index;
                } else {
                    if (min > index - previ) {
                        min = index - previ;
                    }
                    previ = index;
                }
            }

            index++;
            prev = prev.next;
            current = current.next;
        }
        last = previ;
        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        } else {
            max = last - first;
            return new int[]{min, max};
        }

    }

    //-> TC-> O(n) , SC->O(n)
    public int[] nodesBetweenCriticalPoints1(ListNode head) {
        List<Integer> points=new ArrayList<>();
        ListNode prev=head, current=head.next, nextNode=head.next.next;
        int index=0;
        while(nextNode!=null){
            if((prev.val> current.val && current.val<nextNode.val)||
                    (prev.val< current.val && current.val>nextNode.val)){
                points.add(index);
            }
            index++;
            prev=prev.next;
            current=current.next;
            nextNode=nextNode.next;
        }
        if(points.size()<2){
            return new int[]{-1,-1};
        }
        int min=Integer.MAX_VALUE;
        int max=points.get(points.size()-1)-points.get(0);
        for(int i=1;i<points.size();i++){
            min=Math.min(min,points.get(i)-points.get(i-1));
        }
        return new int[]{min,max};
    }
}
