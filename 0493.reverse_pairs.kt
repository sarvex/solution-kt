internal class Solution {
  fun reversePairs(nums: IntArray): Int {
    val ts: TreeSet<Long> = TreeSet()
    for (num in nums) {
      ts.add(num.toLong())
      ts.add(num.toLong() * 2)
    }
    val m: Map<Long, Int> = HashMap()
    var idx = 0
    for (num in ts) {
      m.put(num, ++idx)
    }
    val tree = BinaryIndexedTree(m.size())
    var ans = 0
    for (i in nums.indices.reversed()) {
      val x = m[nums[i].toLong()]!!
      ans += tree.query(x - 1)
      tree.update(m[nums[i].toLong() * 2]!!, 1)
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
