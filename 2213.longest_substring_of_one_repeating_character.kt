import kotlin.math.max

open class Node {
  var l = 0
  var r = 0
  var size = 0
  var lmx = 0
  var rmx = 0
  var mx = 0
  var lc = 0.toChar()
  var rc = 0.toChar()
}

internal class SegmentTree(s: String) {
  private val s: String
  private val tr: Array<Node?>

  init {
    val n = s.length
    this.s = s
    tr = arrayOfNulls(n shl 2)
    for (i in tr.indices) {
      tr[i] = Node()
    }
    build(1, 1, n)
  }

  fun build(u: Int, l: Int, r: Int) {
    tr[u].l = l
    tr[u].r = r
    if (l == r) {
      tr[u].lmx = 1
      tr[u].rmx = 1
      tr[u].mx = 1
      tr[u].size = 1
      tr[u].lc = s[l - 1]
      tr[u].rc = s[l - 1]
      return
    }
    val mid = l + r shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
    pushup(u)
  }

  fun modify(u: Int, x: Int, v: Char) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].lc = v
      tr[u].rc = v
      return
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    if (x <= mid) {
      modify(u shl 1, x, v)
    } else {
      modify(u shl 1 or 1, x, v)
    }
    pushup(u)
  }

  fun query(u: Int, l: Int, r: Int): Node? {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u]
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    if (r <= mid) {
      return query(u shl 1, l, r)
    }
    if (l > mid) {
      return query(u shl 1 or 1, l, r)
    }
    val ans = Node()
    val left = query(u shl 1, l, r)
    val right = query(u shl 1 or 1, l, r)
    pushup(ans, left, right)
    return ans
  }

  fun pushup(root: Node?, left: Node?, right: Node?) {
    root.lc = left.lc
    root.rc = right.rc
    root.size = left.size + right.size
    root.mx = max(left.mx.toDouble(), right.mx.toDouble())
    root.lmx = left.lmx
    root.rmx = right.rmx
    if (left.rc == right.lc) {
      if (left.lmx == left.size) {
        root.lmx += right.lmx
      }
      if (right.rmx == right.size) {
        root.rmx += left.rmx
      }
      root.mx = max(root.mx.toDouble(), (left.rmx + right.lmx).toDouble())
    }
  }

  fun pushup(u: Int) {
    pushup(tr[u], tr[u shl 1], tr[u shl 1 or 1])
  }
}

internal class Solution {
  fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
    val tree = SegmentTree(s)
    val k = queryCharacters.length
    val ans = IntArray(k)
    for (i in 0 until k) {
      val x = queryIndices[i] + 1
      val c = queryCharacters[i]
      tree.modify(1, x, c.code)
      ans[i] = tree.query(1, 1, s.length).mx
    }
    return ans
  }
}
