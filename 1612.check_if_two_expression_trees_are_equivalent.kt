/**
 * Definition for a binary tree node.
 * class Node {
 * char val;
 * Node left;
 * Node right;
 * Node() {this.val = ' ';}
 * Node(char val) { this.val = val; }
 * Node(char val, Node left, Node right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
  fun checkEquivalence(root1: Node?, root2: Node?): Boolean {
    val cnt1 = dfs(root1)
    val cnt2 = dfs(root2)
    for (i in 0..25) {
      if (cnt1[i] != cnt2[i]) {
        return false
      }
    }
    return true
  }

  private fun dfs(root: Node?): IntArray {
    val cnt = IntArray(26)
    if (root == null) {
      return cnt
    }
    if (root.`val` === '+' || root.`val` === '-') {
      val l = dfs(root.left)
      val r = dfs(root.right)
      val k = if (root.`val` === '+') 1 else -1
      for (i in 0..25) {
        cnt[i] += l[i] + r[i] * k
      }
    } else {
      cnt[root.`val` - 'a']++
    }
    return cnt
  }
}
