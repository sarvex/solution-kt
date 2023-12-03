/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
  fun sortedListToBST(head: ListNode?): TreeNode? {
    var head: ListNode? = head
    val nums: List<Int> = ArrayList()
    while (head != null) {
      nums.add(head.`val`)
      head = head.next
    }
    return buildBST(nums, 0, nums.size() - 1)
  }

  private fun buildBST(nums: List<Int>, start: Int, end: Int): TreeNode? {
    if (start > end) {
      return null
    }
    val mid = start + end shr 1
    val root = TreeNode(nums[mid])
    root.left = buildBST(nums, start, mid - 1)
    root.right = buildBST(nums, mid + 1, end)
    return root
  }
}
