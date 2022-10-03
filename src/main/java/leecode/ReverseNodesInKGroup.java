/**
 * 25. Reverse Nodes in k-Group 每k个一组翻转链表
 * 这道题让我们以每k个为一组来翻转链表，实际上是把原链表分成若干小段，然后分别对其进行翻转，
 *
 * 做这道题的基础要先知道单链表反转。
 * 单链表反转 : https://www.jianshu.com/p/84117123f709
 *
 * Created by mengwei on 2019/6/10.
 */
public class ReverseNodesInKGroup {
    /**
     * 第一种解法
     * 那么肯定总共需要两个函数，一个是用来分段的，一个是用来翻转的，
     * 我们就以题目中给的例子来看，对于给定链表 1->2->3->4->5，一般在处理链表问题时，
     * 我们大多时候都会在开头再加一个 dummy node，因为翻转链表时头结点可能会变化，
     * 为了记录当前最新的头结点的位置而引入的 dummy node，那么我们加入 dummy node 后的链表变为 -1->1->2->3->4->5，
     * 如果k为3的话，我们的目标是将 1,2,3 翻转一下，那么我们需要一些指针，pre 和 next 分别指向要翻转的链表的前后的位置，
     * 然后翻转后 pre 的位置更新到如下新的位置：
     *
     * 先将链表分成k个链表，然后将每个链表单独反转。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode pre =  dumpNode;

        int looper = 0;
        ListNode traverse = head;

        while(traverse != null){
            looper ++;
            if (looper % k == 0) {
                pre = reverse(pre, traverse.next);
                traverse = pre.next;
            } else {
                traverse = traverse.next;
            }
        }
        return dumpNode.next;
    }

    /**
     * 第二种解法 可以采用递归的方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        return null;
    }

    public ListNode reverse(ListNode pre,ListNode next){
        ListNode lastNode = pre.next;
        ListNode currentNode = pre.next.next;
        while(currentNode != next){
            lastNode.next = currentNode.next;
            currentNode.next = pre.next;
            pre.next = currentNode;
            currentNode = lastNode.next;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        ListNode head2 = new ListNode(3);
        head1.next = head2;
        ListNode head3 = new ListNode(4);
        head2.next = head3;
        ListNode head4 = new ListNode(5);
        head3.next = head4;
        ListNode listNode = new ReverseNodesInKGroup().reverseKGroup(head, 3);
        while(listNode != null){
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
        System.out.println("args = [" + 6%3+ "]");
    }

}
