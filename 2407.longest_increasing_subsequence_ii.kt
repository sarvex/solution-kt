import kotlin.math.max

class Solution {
  fun lengthOfLIS(nums: IntArray, k: Int): Int {
    var mx = nums[0]
    for (v in nums) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    val tree = SegmentTree(mx)
    var ans = 0
    for (v in nums) {
      val t: Int = tree.query(1, v - k, v - 1) + 1
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      tree.modify(1, v, t)
    }
    return ans
  }
}

internal open class Node {
  var l = 0
  var r = 0
  var v = 0
}

internal class SegmentTree(n: Int) {
  private val tr: Array<Node?>

  init {
    tr = arrayOfNulls(4 * n)
    for (i in tr.indices) {
      tr[i] = Node()
    }
    build(1, 1, n)
  }

  fun build(u: Int, l: Int, r: Int) {
    tr[u].l = l
    tr[u].r = r
    if (l == r) {
      return
    }
    val mid = l + r shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
  }

  fun modify(u: Int, x: Int, v: Int) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].v = v
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

  fun pushup(u: Int) {
    tr[u].v = max(tr[u shl 1].v.toDouble(), tr[u shl 1 or 1].v.toDouble())
  }

  fun query(u: Int, l: Int, r: Int): Int {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].v
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    var v = 0
    if (l <= mid) {
      v = query(u shl 1, l, r)
    }
    if (r > mid) {
      v = max(v.toDouble(), query(u shl 1 or 1, l, r).toDouble()).toInt()
    }
    return v
  }
}
