package 链表;
//给定一个链表，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。
//
//
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
//
//
//
// 示例 1：
//
//
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 104]
// -105 <= Node.val <= 105
// pos 为 -1 或者链表中的一个 有效索引 。
//
// Related Topics 链表 双指针
// 👍 942 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class _141_环形链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 解决思路,快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //1.判断head是否为null或者head.next是否为null
        if(head == null || head.next == null) {
            return false;
        }
        //2.设置慢指针等于head，快指针等于head.next
        ListNode slow = head;
        ListNode fast = head.next;
        //3.当快指针不为null或者快指针的下一个节点不为null,则进行遍历链表
        //条件表达式
        while (fast != null || fast.next != null){
            //慢指针等于慢指针的下一节点
            slow=slow.next;
            //快指针等于快指针的下两个节点
            fast=fast.next.next;
            //如果慢指针等于快指针，则返回true，说明链表是环形链表
            if (slow==fast){
                return true;
            }
        }

        //false说明链表不是环形链表  3
        return  false;
    }
}
