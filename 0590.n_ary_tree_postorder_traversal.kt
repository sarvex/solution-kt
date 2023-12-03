internal class Solution {
  fun postorder(root: Node?): List<Int> {
    var root = root
    val ans: LinkedList<Int> = LinkedList()
    if (root == null) {
      return ans
    }
    val stk: Deque<Node> = ArrayDeque()
    stk.offer(root)
    while (!stk.isEmpty()) {
      root = stk.pollLast()
      ans.addFirst(root.`val`)
      for (child in root.children) {
        stk.offer(child)
      }
    }
    return ans
  }
}
