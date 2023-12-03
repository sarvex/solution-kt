import kotlin.math.max

class BinaryIndexedTree(private val n: Int) {
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

internal class Solution {
  fun minOperations(target: IntArray, arr: IntArray): Int {
    val d: Map<Int, Int> = HashMap()
    for (i in target.indices) {
      d.put(target[i], i)
    }
    val nums: List<Int> = ArrayList()
    for (i in arr.indices) {
      if (d.containsKey(arr[i])) {
        nums.add(d[arr[i]])
      }
    }
    return target.size - lengthOfLIS(nums)
  }

  private fun lengthOfLIS(nums: List<Int>): Int {
    val ts: TreeSet<Int> = TreeSet()
    for (v in nums) {
      ts.add(v)
    }
    var idx = 1
    val d: Map<Int, Int> = HashMap()
    for (v in ts) {
      d.put(v, idx++)
    }
    var ans = 0
    val tree = BinaryIndexedTree(nums.size())
    for (v in nums) {
      val x = d[v]!!
      val t = tree.query(x - 1) + 1
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      tree.update(x, t)
    }
    return ans
  }
}
