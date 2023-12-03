class Solution {
  fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
    val n = nums1.size
    val pos = IntArray(n)
    val tree = BinaryIndexedTree(n)
    for (i in 0 until n) {
      pos[nums2[i]] = i + 1
    }
    var ans: Long = 0
    for (num in nums1) {
      val p = pos[num]
      val left = tree.query(p).toLong()
      val right = (n - p - (tree.query(n) - tree.query(p))).toLong()
      ans += left * right
      tree.update(p, 1)
    }
    return ans
  }
}

internal class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, delta: Int) {
    var x = x
    while (x <= n) {
      c[x] += delta
      x += lowbit(x)
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= lowbit(x)
    }
    return s
  }

  companion object {
    fun lowbit(x: Int): Int {
      return x and -x
    }
  }
}
