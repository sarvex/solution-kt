import kotlin.math.max
import kotlin.math.min

class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] += v
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
  fun createSortedArray(instructions: IntArray): Int {
    var m = 0
    for (x in instructions) {
      m = max(m.toDouble(), x.toDouble()).toInt()
    }
    val tree = BinaryIndexedTree(m)
    var ans = 0
    val mod = 1e9.toInt() + 7
    for (i in instructions.indices) {
      val x = instructions[i]
      val cost = min(tree.query(x - 1).toDouble(), (i - tree.query(x)).toDouble()).toInt()
      ans = (ans + cost) % mod
      tree.update(x, 1)
    }
    return ans
  }
}
