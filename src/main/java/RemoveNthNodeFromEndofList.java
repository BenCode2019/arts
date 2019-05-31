/**
 * 19. Remove Nth Node From End of List
 * 题意就是，从链表中移除倒数第n个节点,条件是只能遍历一遍链表。
 * 有两种算法：第一个就是使用ArrayList和LinkedList来完成，通过ArrayList的下标来删除
 * int index = nodeList.size() - n;
 * nodeList.get(index-1).next = nodeList.get(index).next;
 * 第二种方法是采用快慢指针来操作。
 * 快指针先走n步，如果不为空慢指针再走当，快指针到末尾时，慢指针所指的就是要删除节点的前一个。
 * 参考:以下连接中的第二种方式
 * https://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/
 * Created by mengwei on 2019/5/27.
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 当第一个节点就要删除的时候直接返回head
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null){
            slow.next = slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode1 = new RemoveNthNodeFromEndofList().removeNthFromEnd(listNode, 2);
        while(listNode1 != null){
            System.out.println(listNode1.value);
            listNode1 = listNode1.next;
        }
        System.out.println("---------------------");
        ListNode listNode22 = new ListNode(1);
        ListNode listNode21 = new RemoveNthNodeFromEndofList().removeNthFromEnd(listNode22, 1);
        while(listNode21 != null){
            System.out.println(listNode21.value);
            listNode21 = listNode21.next;
        }
    }
}
