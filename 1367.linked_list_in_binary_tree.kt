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
  fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    return if (root == null) {
      false
    } else dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
  }

  private fun dfs(head: ListNode?, root: TreeNode?): Boolean {
    if (head == null) {
      return true
    }
    return if (root == null || head.`val` !== root.`val`) {
      false
    } else dfs(head.next, root.left) || dfs(head.next, root.right)
  }
}
