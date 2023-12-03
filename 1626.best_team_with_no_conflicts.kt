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
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s = max(s.toDouble(), c[x].toDouble()).toInt()
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
    val n = ages.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(scores[i], ages[i])
    }
    Arrays.sort(arr) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    var m = 0
    for (age in ages) {
      m = max(m.toDouble(), age.toDouble()).toInt()
    }
    val tree = BinaryIndexedTree(m)
    for (x in arr) {
      tree.update(x[1], x[0] + tree.query(x[1]))
    }
    return tree.query(m)
  }
}
