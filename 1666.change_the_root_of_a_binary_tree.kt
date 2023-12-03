internal class Solution {
  fun flipBinaryTree(root: Node, leaf: Node): Node {
    var cur = leaf
    var p: Node = cur.parent
    while (cur !== root) {
      val gp: Node = p.parent
      if (cur.left != null) {
        cur.right = cur.left
      }
      cur.left = p
      p.parent = cur
      if (p.left === cur) {
        p.left = null
      } else if (p.right === cur) {
        p.right = null
      }
      cur = p
      p = gp
    }
    leaf.parent = null
    return leaf
  }
}
