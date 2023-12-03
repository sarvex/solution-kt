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
  fun kBigIndices(nums: IntArray, k: Int): Int {
    val n = nums.size
    val tree1 = BinaryIndexedTree(n)
    val tree2 = BinaryIndexedTree(n)
    for (v in nums) {
      tree2.update(v, 1)
    }
    var ans = 0
    for (v in nums) {
      tree2.update(v, -1)
      if (tree1.query(v - 1) >= k && tree2.query(v - 1) >= k) {
        ++ans
      }
      tree1.update(v, 1)
    }
    return ans
  }
}
