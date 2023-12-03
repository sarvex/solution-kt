internal class ExamRoom(private val n: Int) {
  private val ts: TreeSet<IntArray> = TreeSet { a, b ->
    val d1 = dist(a)
    val d2 = dist(b)
    if (d1 == d2) a.get(0) - b.get(0) else d2 - d1
  }
  private val left: Map<Int, Int> = HashMap()
  private val right: Map<Int, Int> = HashMap()

  init {
    add(intArrayOf(-1, n))
  }

  fun seat(): Int {
    val s: IntArray = ts.first()
    var p = s[0] + s[1] shr 1
    if (s[0] == -1) {
      p = 0
    } else if (s[1] == n) {
      p = n - 1
    }
    del(s)
    add(intArrayOf(s[0], p))
    add(intArrayOf(p, s[1]))
    return p
  }

  fun leave(p: Int) {
    val l = left[p]!!
    val r = right[p]!!
    del(intArrayOf(l, p))
    del(intArrayOf(p, r))
    add(intArrayOf(l, r))
  }

  private fun dist(s: IntArray): Int {
    val l = s[0]
    val r = s[1]
    return if (l == -1 || r == n) r - l - 1 else r - l shr 1
  }

  private fun add(s: IntArray) {
    ts.add(s)
    left.put(s[1], s[0])
    right.put(s[0], s[1])
  }

  private fun del(s: IntArray) {
    ts.remove(s)
    left.remove(s[1])
    right.remove(s[0])
  }
}
