/**
 * 21. Merge Two Sorted Lists
 * 有两种循环和递归实现方法，我采用了循环l1和l2的方式
 * 参考：
 * https://blog.csdn.net/mine_song/article/details/60879939
 * https://blog.csdn.net/mine_song/article/details/60879939
 *
 * Created by mengwei on 2019/5/29.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        // 加head节点是因为返回listnode时候方便。直接返回head就行，要不节点会在最后一个节点。
        ListNode rs = head;
        while(l1 != null && l2 != null){
            if(l1.value <= l2.value){
                rs.next = l1;
                l1 = l1.next;
            }else{
                rs.next = l2;
                l2 = l2.next;
            }
//          rs节点每次付完值都指向下一个节点。
            rs = rs.next;
        }
        if(l1 != null){
            rs.next = l1;
        }
        if(l2 != null){
            rs.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode1 = new MergeTwoSortedLists().mergeTwoLists(listNode, listNode4);
        while(listNode1.next != null){
            System.out.println(listNode1.value);
            listNode1 = listNode1.next;
        }
        System.out.println(listNode1.value);
    }
}
