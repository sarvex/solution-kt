internal class Solution {
  fun cloneTree(root: Node?): Node? {
    if (root == null) {
      return null
    }
    val children: ArrayList<Node?> = ArrayList()
    for (child in root.children) {
      children.add(cloneTree(child))
    }
    return Node(root.`val`, children)
  }
}
