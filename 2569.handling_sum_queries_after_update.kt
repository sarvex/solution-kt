open class Node {
  var l = 0
  var r = 0
  var s = 0
  var lazy = 0
}

internal class SegmentTree(nums: IntArray) {
  private val tr: Array<Node?>
  private val nums: IntArray

  init {
    val n = nums.size
    this.nums = nums
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
      tr[u].s = nums[l - 1]
      return
    }
    val mid = l + r shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
    pushup(u)
  }

  fun modify(u: Int, l: Int, r: Int) {
    if (tr[u].l >= l && tr[u].r <= r) {
      tr[u].lazy = tr[u].lazy xor 1
      tr[u].s = tr[u].r - tr[u].l + 1 - tr[u].s
      return
    }
    pushdown(u)
    val mid: Int = tr[u].l + tr[u].r shr 1
    if (l <= mid) {
      modify(u shl 1, l, r)
    }
    if (r > mid) {
      modify(u shl 1 or 1, l, r)
    }
    pushup(u)
  }

  fun query(u: Int, l: Int, r: Int): Int {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].s
    }
    pushdown(u)
    val mid: Int = tr[u].l + tr[u].r shr 1
    var res = 0
    if (l <= mid) {
      res += query(u shl 1, l, r)
    }
    if (r > mid) {
      res += query(u shl 1 or 1, l, r)
    }
    return res
  }

  private fun pushup(u: Int) {
    tr[u].s = tr[u shl 1].s + tr[u shl 1 or 1].s
  }

  private fun pushdown(u: Int) {
    if (tr[u].lazy == 1) {
      val mid: Int = tr[u].l + tr[u].r shr 1
      tr[u shl 1].s = mid - tr[u].l + 1 - tr[u shl 1].s
      tr[u shl 1].lazy = tr[u shl 1].lazy xor 1
      tr[u shl 1 or 1].s = tr[u].r - mid - tr[u shl 1 or 1].s
      tr[u shl 1 or 1].lazy = tr[u shl 1 or 1].lazy xor 1
      tr[u].lazy = tr[u].lazy xor 1
    }
  }
}

internal class Solution {
  fun handleQuery(nums1: IntArray?, nums2: IntArray, queries: Array<IntArray>): LongArray {
    val tree = SegmentTree(nums1)
    var s: Long = 0
    for (x in nums2) {
      s += x.toLong()
    }
    var m = 0
    for (q in queries) {
      if (q[0] == 3) {
        ++m
      }
    }
    val ans = LongArray(m)
    var i = 0
    for (q in queries) {
      if (q[0] == 1) {
        tree.modify(1, q[1] + 1, q[2] + 1)
      } else if (q[0] == 2) {
        s += 1L * q[1] * tree.query(1, 1, nums2.size)
      } else {
        ans[i++] = s
      }
    }
    return ans
  }
}
