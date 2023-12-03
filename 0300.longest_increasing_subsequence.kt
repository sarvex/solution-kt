import kotlin.math.max

internal class Solution {
  fun lengthOfLIS(nums: IntArray): Int {
    val s = nums.clone()
    Arrays.sort(s)
    var m = 0
    val n = s.size
    for (i in 0 until n) {
      if (i == 0 || s[i] != s[i - 1]) {
        s[m++] = s[i]
      }
    }
    val tree = BinaryIndexedTree(m)
    for (x in nums) {
      x = search(s, x, m)
      val t = tree.query(x - 1) + 1
      tree.update(x, t)
    }
    return tree.query(m)
  }

  private fun search(nums: IntArray, x: Int, r: Int): Int {
    var r = r
    var l = 0
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l + 1
  }
}

internal class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x].toDouble(), v.toDouble()).toInt()
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var mx = 0
    while (x > 0) {
      mx = max(mx.toDouble(), c[x].toDouble()).toInt()
      x -= x and -x
    }
    return mx
  }
}
