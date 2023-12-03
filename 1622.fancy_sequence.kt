open class Node(var l: Int, var r: Int) {
  var left: Node? = null
  var right: Node? = null
  var mid: Int
  var v: Long = 0
  var add: Long = 0
  var mul: Long = 1

  init {
    mid = l + r shr 1
  }
}

internal class SegmentTree {
  private val root = Node(1, 1e5.toInt() + 1)
  @JvmOverloads
  fun modifyAdd(l: Int, r: Int, inc: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v = (node.v + (node.r - node.l + 1) * inc) % SegmentTree.Companion.MOD
      node.add = (node.add + inc) % SegmentTree.Companion.MOD
      return
    }
    pushdown(node)
    if (l <= node.mid) {
      modifyAdd(l, r, inc, node.left)
    }
    if (r > node.mid) {
      modifyAdd(l, r, inc, node.right)
    }
    pushup(node)
  }

  @JvmOverloads
  fun modifyMul(l: Int, r: Int, m: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v = node.v * m % SegmentTree.Companion.MOD
      node.add = node.add * m % SegmentTree.Companion.MOD
      node.mul = node.mul * m % SegmentTree.Companion.MOD
      return
    }
    pushdown(node)
    if (l <= node.mid) {
      modifyMul(l, r, m, node.left)
    }
    if (r > node.mid) {
      modifyMul(l, r, m, node.right)
    }
    pushup(node)
  }

  @JvmOverloads
  fun query(l: Int, r: Int, node: Node = root): Int {
    if (l > r) {
      return 0
    }
    if (node.l >= l && node.r <= r) {
      return node.v.toInt()
    }
    pushdown(node)
    var v = 0
    if (l <= node.mid) {
      v = (v + query(l, r, node.left)) % SegmentTree.Companion.MOD
    }
    if (r > node.mid) {
      v = (v + query(l, r, node.right)) % SegmentTree.Companion.MOD
    }
    return v
  }

  fun pushup(node: Node) {
    node.v = (node.left.v + node.right.v) % SegmentTree.Companion.MOD
  }

  fun pushdown(node: Node) {
    if (node.left == null) {
      node.left = Node(node.l, node.mid)
    }
    if (node.right == null) {
      node.right = Node(node.mid + 1, node.r)
    }
    if (node.add != 0L || node.mul != 1L) {
      val left: Node = node.left
      val right: Node = node.right
      left.v = (left.v * node.mul + (left.r - left.l + 1) * node.add) % SegmentTree.Companion.MOD
      right.v = (right.v * node.mul + (right.r - right.l + 1) * node.add) % SegmentTree.Companion.MOD
      left.add = (left.add * node.mul + node.add) % SegmentTree.Companion.MOD
      right.add = (right.add * node.mul + node.add) % SegmentTree.Companion.MOD
      left.mul = left.mul * node.mul % SegmentTree.Companion.MOD
      right.mul = right.mul * node.mul % SegmentTree.Companion.MOD
      node.add = 0
      node.mul = 1
    }
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}

internal class Fancy {
  private var n = 0
  private val tree = SegmentTree()
  fun append(`val`: Int) {
    ++n
    tree.modifyAdd(n, n, `val`)
  }

  fun addAll(inc: Int) {
    tree.modifyAdd(1, n, inc)
  }

  fun multAll(m: Int) {
    tree.modifyMul(1, n, m)
  }

  fun getIndex(idx: Int): Int {
    return if (idx >= n) -1 else tree.query(idx + 1, idx + 1)
  }
}
