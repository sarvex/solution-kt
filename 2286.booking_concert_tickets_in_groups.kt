import kotlin.math.max

open class Node {
  var l = 0
  var r = 0
  var mx: Long = 0
  var s: Long = 0
}

internal class SegmentTree(n: Int, private val m: Int) {
  private val tr: Array<Node?>

  init {
    tr = arrayOfNulls(n shl 2)
    for (i in tr.indices) {
      tr[i] = Node()
    }
    build(1, 1, n)
  }

  private fun build(u: Int, l: Int, r: Int) {
    tr[u].l = l
    tr[u].r = r
    if (l == r) {
      tr[u].s = m.toLong()
      tr[u].mx = m.toLong()
      return
    }
    val mid = l + r shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
    pushup(u)
  }

  fun modify(u: Int, x: Int, v: Long) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].s = v
      tr[u].mx = v
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

  fun querySum(u: Int, l: Int, r: Int): Long {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].s
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    var v: Long = 0
    if (l <= mid) {
      v += querySum(u shl 1, l, r)
    }
    if (r > mid) {
      v += querySum(u shl 1 or 1, l, r)
    }
    return v
  }

  fun queryIdx(u: Int, l: Int, r: Int, k: Int): Int {
    if (tr[u].mx < k) {
      return 0
    }
    if (tr[u].l == tr[u].r) {
      return tr[u].l
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    if (tr[u shl 1].mx >= k) {
      return queryIdx(u shl 1, l, r, k)
    }
    return if (r > mid) {
      queryIdx(u shl 1 or 1, l, r, k)
    } else 0
  }

  private fun pushup(u: Int) {
    tr[u].s = tr[u shl 1].s + tr[u shl 1 or 1].s
    tr[u].mx = max(tr[u shl 1].mx.toDouble(), tr[u shl 1 or 1].mx.toDouble())
  }
}

internal class BookMyShow(private val n: Int, private val m: Int) {
  private val tree: SegmentTree

  init {
    tree = SegmentTree(n, m)
  }

  fun gather(k: Int, maxRow: Int): IntArray {
    var maxRow = maxRow
    ++maxRow
    val i: Int = tree.queryIdx(1, 1, maxRow, k)
    if (i == 0) {
      return intArrayOf()
    }
    val s: Long = tree.querySum(1, i, i)
    tree.modify(1, i, (s - k).toInt())
    return intArrayOf(i - 1, (m - s).toInt())
  }

  fun scatter(k: Int, maxRow: Int): Boolean {
    var k = k
    var maxRow = maxRow
    ++maxRow
    if (tree.querySum(1, 1, maxRow) < k) {
      return false
    }
    val i: Int = tree.queryIdx(1, 1, maxRow, 1)
    for (j in i..n) {
      val s: Long = tree.querySum(1, j, j)
      if (s >= k) {
        tree.modify(1, j, (s - k).toInt())
        return true
      }
      k -= s.toInt()
      tree.modify(1, j, 0)
    }
    return true
  }
}
