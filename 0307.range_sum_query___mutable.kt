internal class BinaryIndexedTree(private val n: Int) {
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

internal class NumArray(nums: IntArray) {
  private val tree: BinaryIndexedTree

  init {
    val n = nums.size
    tree = BinaryIndexedTree(n)
    for (i in 0 until n) {
      tree.update(i + 1, nums[i])
    }
  }

  fun update(index: Int, `val`: Int) {
    val prev = sumRange(index, index)
    tree.update(index + 1, `val` - prev)
  }

  fun sumRange(left: Int, right: Int): Int {
    return tree.query(right + 1) - tree.query(left)
  }
}
