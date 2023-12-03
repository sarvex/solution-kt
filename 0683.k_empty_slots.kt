internal class Solution {
  fun kEmptySlots(bulbs: IntArray, k: Int): Int {
    val n = bulbs.size
    val tree = BinaryIndexedTree(n)
    val vis = BooleanArray(n + 1)
    for (i in 1..n) {
      val x = bulbs[i - 1]
      tree.update(x, 1)
      vis[x] = true
      var y = x - k - 1
      if (y > 0 && vis[y] && tree.query(x - 1) - tree.query(y) == 0) {
        return i
      }
      y = x + k + 1
      if (y <= n && vis[y] && tree.query(y - 1) - tree.query(x) == 0) {
        return i
      }
    }
    return -1
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
