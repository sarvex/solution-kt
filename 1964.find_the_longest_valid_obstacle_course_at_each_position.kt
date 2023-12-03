import kotlin.math.max

class Solution {
  fun lengthOfLIS(nums: IntArray): Int {
    val ts: TreeSet<Int> = TreeSet()
    for (v in nums) {
      ts.add(v)
    }
    var idx = 1
    val m: Map<Int, Int> = HashMap()
    for (v in ts) {
      m.put(v, idx++)
    }
    val tree = BinaryIndexedTree(m.size())
    var ans = 1
    for (v in nums) {
      val x = m[v]!!
      val t = tree.query(x - 1) + 1
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      tree.update(x, t)
    }
    return ans
  }
}

internal class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, `val`: Int) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x].toDouble(), `val`.toDouble()).toInt()
      x += lowbit(x)
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s = max(s.toDouble(), c[x].toDouble()).toInt()
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
