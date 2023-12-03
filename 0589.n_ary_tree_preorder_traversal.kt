internal class Solution {
  fun preorder(root: Node?): List<Int> {
    if (root == null) {
      return Collections.emptyList()
    }
    val ans: List<Int> = ArrayList()
    val stk: Deque<Node> = ArrayDeque()
    stk.push(root)
    while (!stk.isEmpty()) {
      val node: Node = stk.pop()
      ans.add(node.`val`)
      val children: List<Node> = node.children
      for (i in children.size() - 1 downTo 0) {
        stk.push(children[i])
      }
    }
    return ans
  }
}
