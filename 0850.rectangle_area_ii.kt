internal open class Node {
  @JvmField
  var l = 0
  @JvmField
  var r = 0
  @JvmField
  var cnt = 0
  var length = 0
}

internal class SegmentTree(private val nums: IntArray) {
  private val tr: Array<Node?>

  init {
    val n = nums.size - 1
    tr = arrayOfNulls(n shl 2)
    for (i in tr.indices) {
      tr[i] = Node()
    }
    build(1, 0, n - 1)
  }

  private fun build(u: Int, l: Int, r: Int) {
    tr[u].l = l
    tr[u].r = r
    if (l != r) {
      val mid = l + r shr 1
      build(u shl 1, l, mid)
      build(u shl 1 or 1, mid + 1, r)
    }
  }

  fun modify(u: Int, l: Int, r: Int, k: Int) {
    if (tr[u].l >= l && tr[u].r <= r) {
      tr[u].cnt += k
    } else {
      val mid: Int = tr[u].l + tr[u].r shr 1
      if (l <= mid) {
        modify(u shl 1, l, r, k)
      }
      if (r > mid) {
        modify(u shl 1 or 1, l, r, k)
      }
    }
    pushup(u)
  }

  private fun pushup(u: Int) {
    if (tr[u].cnt > 0) {
      tr[u].length = nums[tr[u].r + 1] - nums[tr[u].l]
    } else if (tr[u].l == tr[u].r) {
      tr[u].length = 0
    } else {
      tr[u].length = tr[u shl 1].length + tr[u shl 1 or 1].length
    }
  }

  fun query(): Int {
    return tr[1].length
  }
}

internal class Solution {
  fun rectangleArea(rectangles: Array<IntArray>): Int {
    val n = rectangles.size
    val segs = Array(n shl 1) { IntArray(4) }
    var i = 0
    val ts: TreeSet<Int> = TreeSet()
    for (e in rectangles) {
      val x1 = e[0]
      val y1 = e[1]
      val x2 = e[2]
      val y2 = e[3]
      segs[i++] = intArrayOf(x1, y1, y2, 1)
      segs[i++] = intArrayOf(x2, y1, y2, -1)
      ts.add(y1)
      ts.add(y2)
    }
    Arrays.sort(segs) { a, b -> a.get(0) - b.get(0) }
    val m: Map<Int, Int> = HashMap(ts.size())
    i = 0
    val nums = IntArray(ts.size())
    for (v in ts) {
      m.put(v, i)
      nums[i++] = v
    }
    val tree = SegmentTree(nums)
    var ans: Long = 0
    i = 0
    while (i < segs.size) {
      val e = segs[i]
      val x = e[0]
      val y1 = e[1]
      val y2 = e[2]
      val k = e[3]
      if (i > 0) {
        ans += tree.query().toLong() * (x - segs[i - 1][0])
      }
      tree.modify(1, m[y1]!!, m[y2]!! - 1, k)
      ++i
    }
    ans %= Solution.Companion.MOD.toLong()
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
