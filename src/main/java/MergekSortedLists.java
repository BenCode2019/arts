import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * 把k个已经排好序的链表整合到一个链表中，并且这个链表是排了序的。
 *
 * 方法1 采用优先队列，优先队列采用最小堆的方式将n个链表的头一个节点存入队列，
 * 先弹出最小的一个，然后将其后面的节点加入优先队列。直到所有的链表为空，返回最终的链表。
 * 参考java版的优先队列与分治法-数组的开始与中间往后移动 https://blog.csdn.net/Jin_Kwok/article/details/51582176
 *
 * 方法2 采用分治法
 *
 * 参考思路：https://www.cnblogs.com/zywscq/p/5403051.html
 *
 * 参考分治法-数组的两端往中间分治: https://blog.csdn.net/katrina95/article/details/79112038
 *
 * Created by mengwei on 2019/6/3.
 */
public class MergekSortedLists {

    /**
     * 方法1 采用优先队列方式实现 优先队列采用最小堆的方式将n个链表的头一个节点存入队列，
     * 先弹出最小的一个，然后将其后面的节点加入优先队列。直到所有的链表为空，返回最终的链表。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <= 0 ){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(11,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if(list != null){
                pq.offer(list);
            }
        }
        ListNode rs = new ListNode(0);
        // 将phead作为指向节点的指针，避免rs的节点指针不在首节点。
        ListNode phead = rs;
        while(pq.peek() != null){
            ListNode poll = (ListNode) pq.poll();
            phead.next = poll;
            phead = phead.next;
            if(poll.next != null){
                pq.offer(poll.next);
            }
        }
        return rs.next;
    }

    /**
     * 方法1 采用优先队列方式实现 优化版 将所有节点都存入优先队列，然后在逐个取出
     * @param lists
     * @return
     */
    public ListNode mergeKListsBetter(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(ListNode list: lists){
            while(list != null){
                pq.add(list.value);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while(!pq.isEmpty()){
            dummy.next = new ListNode(pq.remove());
            dummy = dummy.next;
        }
        return ans.next;
    }

    /**
     * 方法2 采用分治法实现,从数组的两端往中间分治
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length <= 0 ){
            return null;
        }
        int begin = 0;
        int end = lists.length - 1;
        while(begin < end){
            int mid = (begin + end - 1) / 2;
            for (int i = 0; i <= mid; i++) {
                lists[i] = mergeListNode(lists[i],lists[end - i]);
            }
            end = (begin + end) / 2;
        }
        return lists[0];
    }

    /**
     * 合并两个ListNode
     * @return
     */
    public ListNode mergeListNode(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode rs = new ListNode(0);
        ListNode phead = rs;
        if(l1 != null && l2 != null){
            while(l1 != null && l2 != null){
                if(l1.value < l2.value){
                    phead.next = l1;
                    l1 = l1.next;
                }else{
                    phead.next = l2;
                    l2 = l2.next;
                }
                phead = phead.next;
            }
        }
        if(l1 != null){
            phead.next = l1;
            l1 = l1.next;
        }else{
            phead.next = l2;
            l2 = l2.next;
        }
        return rs.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode listnode1 = new ListNode(1);
        ListNode listnode2 = new ListNode(4);
        ListNode listnode3 = new ListNode(5);
        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listNodes[0] = listnode1;

        ListNode listnode4 = new ListNode(1);
        ListNode listnode5 = new ListNode(3);
        ListNode listnode6 = new ListNode(4);
        listnode4.next = listnode5;
        listnode5.next = listnode6;
        listNodes[1] = listnode4;

        ListNode listnode7 = new ListNode(2);
        ListNode listnode8 = new ListNode(6);
        listnode7.next = listnode8;
        listNodes[2] = listnode7;
        ListNode listNode = new MergekSortedLists().mergeKListsBetter(listNodes);
        while(listNode.next != null){
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
        System.out.println(listNode.value);

        ListNode[] listNodes2 = new ListNode[3];
        ListNode listNode2 = new MergekSortedLists().mergeKLists(listNodes2);

    }
}
