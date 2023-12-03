import kotlin.math.max

internal open class Node(var l: Int, var r: Int) {
  @JvmField
  var left: Node? = null
  @JvmField
  var right: Node? = null
  @JvmField
  var mid: Int
  @JvmField
  var v = 0
  @JvmField
  var add = 0

  init {
    mid = l + r shr 1
  }
}

internal class SegmentTree {
  private val root = Node(1, 1e9.toInt() + 1)
  @JvmOverloads
  fun modify(l: Int, r: Int, v: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v += v
      node.add += v
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
      v = max(v.toDouble(), query(l, r, node.left).toDouble()).toInt()
    }
    if (r > node.mid) {
      v = max(v.toDouble(), query(l, r, node.right).toDouble()).toInt()
    }
    return v
  }

  fun pushup(node: Node) {
    node.v = max(node.left.v.toDouble(), node.right.v.toDouble())
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
      left.add += node.add
      right.add += node.add
      left.v += node.add
      right.v += node.add
      node.add = 0
    }
  }
}

internal class MyCalendarThree {
  private val tree = SegmentTree()
  fun book(start: Int, end: Int): Int {
    tree.modify(start + 1, end, 1)
    return tree.query(1, 1e9.toInt() + 1)
  }
}
