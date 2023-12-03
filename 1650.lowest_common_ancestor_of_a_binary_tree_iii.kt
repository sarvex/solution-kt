internal class Solution {
  fun lowestCommonAncestor(p: Node, q: Node): Node {
    var a = p
    var b = q
    while (a !== b) {
      a = if (a.parent == null) q else a.parent
      b = if (b.parent == null) p else b.parent
    }
    return a
  }
}
