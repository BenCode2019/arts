/**
 * Created by mengwei on 2019/3/18.
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final int val = l1.val;
        ListNode rs = null;
        ListNode headRs = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;

            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int s = val1 + val2 + carry;
            if(s > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            s = s % 10;
            if(rs == null){
                rs = new ListNode(s);
                headRs = rs;
            }else{
                rs.next = new ListNode(s);
                rs = rs.next;
            }

            if(carry == 1){
                rs.next = new ListNode(1);
            }
        }
        return headRs;
    }

    /**
     * 优化的解决方案,
     * 1 用除法的方式去掉了进位的判断carry = sum / 10;
     * 2 采用假head，省掉了，rs==null的判断。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = 0;
            int y = 0;
            if(p != null){
                x = p.val;
                p = p.next;
            }
            if(q != null){
                y = q.val;
                q = q.next;
            }
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
//        test one 2 4 3 , 5 6 4 = 7 0 8
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode anwer = addTwoNumbers(l1,l2);
//        System.out.println(anwer.val+" "+anwer.next.val+" "+anwer.next.next.val);

//        test two 1 8 , 0 = 1 8
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        ListNode l2 = new ListNode(0);
//        ListNode anwer = addTwoNumbers2(l1,l2);
//        System.out.println(anwer.val+" "+anwer.next.val+" ");

//        test three 5 ,5 = 0 1
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(5);
        ListNode anwer2 = addTwoNumbers2(l3,l4);
        System.out.println(anwer2.val+" "+anwer2.next.val+" ");
    }
}
