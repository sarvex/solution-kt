class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, delta: Int) {
    var x = x
    while (x <= n) {
      c[x] += delta
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun countOperationsToEmptyArray(nums: IntArray): Long {
    val n = nums.size
    val pos: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      pos.put(nums[i], i)
    }
    Arrays.sort(nums)
    var ans = (pos[nums[0]]!! + 1).toLong()
    val tree = BinaryIndexedTree(n)
    for (k in 0 until n - 1) {
      val i = pos[nums[k]]!!
      val j = pos[nums[k + 1]]!!
      val d = (j - i - (tree.query(j + 1) - tree.query(i + 1))).toLong()
      ans += d + (n - k) * if (i > j) 1 else 0
      tree.update(i + 1, 1)
    }
    return ans
  }
}
