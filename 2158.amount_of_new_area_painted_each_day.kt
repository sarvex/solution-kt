open class Node(var l: Int, var r: Int) {
  var left: Node? = null
  var right: Node? = null
  var mid: Int
  var v = 0
  var add = 0

  init {
    mid = l + r shr 1
  }
}

internal class SegmentTree {
  private val root = Node(1, 100010)
  @JvmOverloads
  fun modify(l: Int, r: Int, v: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v = node.r - node.l + 1
      node.add = v
      return
    }
    pushdown(node)
    if (l <= node.mid) {
      modify(l, r, v, node.left)
    }
    if (r > node.mid) {
      modify(l, r, v, node.right)
    }
    pushup(node)
  }

  @JvmOverloads
  fun query(l: Int, r: Int, node: Node = root): Int {
    if (l > r) {
      return 0
    }
    if (node.l >= l && node.r <= r) {
      return node.v
    }
    pushdown(node)
    var v = 0
    if (l <= node.mid) {
      v += query(l, r, node.left)
    }
    if (r > node.mid) {
      v += query(l, r, node.right)
    }
    return v
  }

  fun pushup(node: Node) {
    node.v = node.left.v + node.right.v
  }

  fun pushdown(node: Node) {
    if (node.left == null) {
      node.left = Node(node.l, node.mid)
    }
    if (node.right == null) {
      node.right = Node(node.mid + 1, node.r)
    }
    if (node.add != 0) {
      val left: Node = node.left
      val right: Node = node.right
      left.add = node.add
      right.add = node.add
      left.v = left.r - left.l + 1
      right.v = right.r - right.l + 1
      node.add = 0
    }
  }
}

internal class Solution {
  fun amountPainted(paint: Array<IntArray>): IntArray {
    val tree = SegmentTree()
    val n = paint.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      val l = paint[i][0] + 1
      val r = paint[i][1]
      val v: Int = tree.query(l, r)
      ans[i] = r - l + 1 - v
      tree.modify(l, r, 1)
    }
    return ans
  }
}
