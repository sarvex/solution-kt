internal class BinaryIndexedTree(n: Int) {
  private val n: Int
  private val c: IntArray

  init {
    var n = n
    n += 1e5.toInt() + 1
    this.n = n
    c = IntArray(n + 1)
  }

  fun update(x: Int, delta: Int) {
    var x = x
    x += 1e5.toInt() + 1
    while (x <= n) {
      c[x] += delta
      x += lowbit(x)
    }
  }

  fun query(x: Int): Int {
    var x = x
    x += 1e5.toInt() + 1
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= lowbit(x)
    }
    return s
  }

  companion object {
    fun lowbit(x: Int): Int {
      var x = x
      x += 1e5.toInt() + 1
      return x and -x
    }
  }
}

internal class Solution {
  fun subarraysWithMoreZerosThanOnes(nums: IntArray): Int {
    val n = nums.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + if (nums[i] == 1) 1 else -1
    }
    val tree = BinaryIndexedTree(n + 1)
    var ans = 0
    for (v in s) {
      ans = (ans + tree.query(v - 1)) % Solution.Companion.MOD
      tree.update(v, 1)
    }
    return ans
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
