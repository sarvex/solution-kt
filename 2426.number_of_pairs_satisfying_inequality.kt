class BinaryIndexedTree(private val n: Int) {
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

internal class Solution {
  fun numberOfPairs(nums1: IntArray, nums2: IntArray, diff: Int): Long {
    val tree = BinaryIndexedTree(100000)
    var ans: Long = 0
    for (i in nums1.indices) {
      val v = nums1[i] - nums2[i]
      ans += tree.query(v + diff + 40000).toLong()
      tree.update(v + 40000, 1)
    }
    return ans
  }
}
