/**
 * 24. Swap Nodes in Pairs
 * 用图表示的更清楚，可以把线看成node.next
 * 参考：https://blog.csdn.net/camellhf/article/details/72866053
 * Created by mengwei on 2019/6/5.
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode rs = new ListNode(0);
        ListNode tmp = rs;
        tmp.next = head;  // 1
        ListNode first = tmp.next;
        while(tmp != null){
            if(tmp.next == null || tmp.next.next == null){
                return rs.next;
            }
            first = tmp.next;
            tmp.next = first.next; //2
            first.next = first.next.next; //3
            //这里不用first.next是因为first.next已经指向第三个节点了
            tmp.next.next = first; //4
            tmp = first;
        }
        return rs.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode1 = new SwapNodesinPairs().swapPairs(listNode);
        while(listNode1 != null){
            System.out.println(listNode1.value);
            listNode1 = listNode1.next;
        }
//        System.out.println(listNode1.value);
    }

}
