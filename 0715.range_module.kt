internal open class Node {
  var left: Node? = null
  var right: Node? = null
  var add = 0
  var v = false
}

internal class SegmentTree {
  private val root = Node()
  @JvmOverloads
  fun modify(left: Int, right: Int, v: Int, l: Int = 1, r: Int = 1e9.toInt(), node: Node = root) {
    if (l >= left && r <= right) {
      node.v = v == 1
      node.add = v
      return
    }
    pushdown(node)
    val mid = l + r shr 1
    if (left <= mid) {
      modify(left, right, v, l, mid, node.left)
    }
    if (right > mid) {
      modify(left, right, v, mid + 1, r, node.right)
    }
    pushup(node)
  }

  @JvmOverloads
  fun query(left: Int, right: Int, l: Int = 1, r: Int = 1e9.toInt(), node: Node = root): Boolean {
    if (l >= left && r <= right) {
      return node.v
    }
    pushdown(node)
    val mid = l + r shr 1
    var v = true
    if (left <= mid) {
      v = v && query(left, right, l, mid, node.left)
    }
    if (right > mid) {
      v = v && query(left, right, mid + 1, r, node.right)
    }
    return v
  }

  fun pushup(node: Node) {
    node.v = node.left != null && node.left.v && node.right != null && node.right.v
  }

  fun pushdown(node: Node) {
    if (node.left == null) {
      node.left = Node()
    }
    if (node.right == null) {
      node.right = Node()
    }
    if (node.add != 0) {
      node.left.add = node.add
      node.right.add = node.add
      node.left.v = node.add == 1
      node.right.v = node.add == 1
      node.add = 0
    }
  }
}

internal class RangeModule {
  private val tree = SegmentTree()
  fun addRange(left: Int, right: Int) {
    tree.modify(left, right - 1, 1)
  }

  fun queryRange(left: Int, right: Int): Boolean {
    return tree.query(left, right - 1)
  }

  fun removeRange(left: Int, right: Int) {
    tree.modify(left, right - 1, -1)
  }
}
