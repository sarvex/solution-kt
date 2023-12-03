internal open class Node {
  var l = 0
  var r = 0
  var x = 0
  var cnt = 0
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
      tr[u].x = nums[l - 1]
      tr[u].cnt = 1
      return
    }
    val mid = l + r shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
    pushup(u)
  }

  fun query(u: Int, l: Int, r: Int): IntArray {
    if (tr[u].l >= l && tr[u].r <= r) {
      return intArrayOf(tr[u].x, tr[u].cnt)
    }
    val mid: Int = tr[u].l + tr[u].r shr 1
    if (r <= mid) {
      return query(u shl 1, l, r)
    }
    if (l > mid) {
      return query(u shl 1 or 1, l, r)
    }
    var left = query(u shl 1, l, r)
    val right = query(u shl 1 or 1, l, r)
    if (left[0] == right[0]) {
      left[1] += right[1]
    } else if (left[1] >= right[1]) {
      left[1] -= right[1]
    } else {
      right[1] -= left[1]
      left = right
    }
    return left
  }

  private fun pushup(u: Int) {
    if (tr[u shl 1].x == tr[u shl 1 or 1].x) {
      tr[u].x = tr[u shl 1].x
      tr[u].cnt = tr[u shl 1].cnt + tr[u shl 1 or 1].cnt
    } else if (tr[u shl 1].cnt >= tr[u shl 1 or 1].cnt) {
      tr[u].x = tr[u shl 1].x
      tr[u].cnt = tr[u shl 1].cnt - tr[u shl 1 or 1].cnt
    } else {
      tr[u].x = tr[u shl 1 or 1].x
      tr[u].cnt = tr[u shl 1 or 1].cnt - tr[u shl 1].cnt
    }
  }
}

internal class MajorityChecker(arr: IntArray) {
  private val tree: SegmentTree
  private val d: Map<Int, List<Int>> = HashMap()

  init {
    tree = SegmentTree(arr)
    for (i in arr.indices) {
      d.computeIfAbsent(arr[i]) { k -> ArrayList() }.add(i)
    }
  }

  fun query(left: Int, right: Int, threshold: Int): Int {
    val x: Int = tree.query(1, left + 1, right + 1).get(0)
    val l = search(d[x]!!, left)
    val r = search(d[x]!!, right + 1)
    return if (r - l >= threshold) x else -1
  }

  private fun search(arr: List<Int>, x: Int): Int {
    var left = 0
    var right: Int = arr.size()
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
