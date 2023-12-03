internal class Solution {
  fun countSmaller(nums: IntArray): List<Int> {
    val s: Set<Int> = HashSet()
    for (v in nums) {
      s.add(v)
    }
    val alls: List<Int> = ArrayList(s)
    alls.sort(Comparator.comparingInt { a -> a })
    val n: Int = alls.size()
    val m: Map<Int, Int> = HashMap(n)
    for (i in 0 until n) {
      m.put(alls[i], i + 1)
    }
    val tree = BinaryIndexedTree(n)
    val ans: LinkedList<Int> = LinkedList()
    for (i in nums.indices.reversed()) {
      val x = m[nums[i]]!!
      tree.update(x, 1)
      ans.addFirst(tree.query(x - 1))
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
