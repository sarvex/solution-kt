internal class Solution {
  fun findRoot(tree: List<Node>): Node {
    var x = 0
    for (node in tree) {
      x = x xor node.`val`
      for (child in node.children) {
        x = x xor child.`val`
      }
    }
    var i = 0
    while (true) {
      if (tree[i].`val` === x) {
        return tree[i]
      }
      ++i
    }
  }
}
