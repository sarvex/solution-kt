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

internal class MRUQueue(private var n: Int) {
  private val q: IntArray
  private val tree: BinaryIndexedTree

  init {
    q = IntArray(n + 2010)
    for (i in 1..n) {
      q[i] = i
    }
    tree = BinaryIndexedTree(n + 2010)
  }

  fun fetch(k: Int): Int {
    var l = 1
    var r = n
    while (l < r) {
      val mid = l + r shr 1
      if (mid - tree.query(mid) >= k) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    val x = q[l]
    q[++n] = x
    tree.update(l, 1)
    return x
  }
}
