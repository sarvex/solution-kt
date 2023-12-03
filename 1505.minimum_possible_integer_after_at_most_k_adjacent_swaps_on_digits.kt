class Solution {
  fun minInteger(num: String, k: Int): String {
    var k = k
    val pos: Array<Queue<Int>?> = arrayOfNulls<Queue>(10)
    for (i in 0..9) {
      pos[i] = ArrayDeque()
    }
    val n = num.length
    for (i in 0 until n) {
      pos[num[i].code - '0'.code].offer(i + 1)
    }
    val ans = StringBuilder()
    val tree = BinaryIndexedTree(n)
    for (i in 1..n) {
      for (v in 0..9) {
        if (!pos[v].isEmpty()) {
          val q: Queue<Int>? = pos[v]
          val j: Int = q.peek()
          val dist = tree.query(n) - tree.query(j) + j - i
          if (dist <= k) {
            k -= dist
            q.poll()
            ans.append(v)
            tree.update(j, 1)
            break
          }
        }
      }
    }
    return ans.toString()
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
