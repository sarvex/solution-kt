import java.util.*

internal class Solution {
  fun alienOrder(words: Array<String>): String {
    val g = Array(26) { BooleanArray(26) }
    val s = BooleanArray(26)
    var cnt = 0
    val n = words.size
    for (i in 0 until n - 1) {
      for (c in words[i].toCharArray()) {
        if (cnt == 26) {
          break
        }
        (c -= 'a').toChar()
        if (!s[c.code]) {
          ++cnt
          s[c.code] = true
        }
      }
      val m = words[i].length
      for (j in 0 until m) {
        if (j >= words[i + 1].length) {
          return ""
        }
        val c1 = words[i][j]
        val c2 = words[i + 1][j]
        if (c1 == c2) {
          continue
        }
        if (g[c2.code - 'a'.code][c1.code - 'a'.code]) {
          return ""
        }
        g[c1.code - 'a'.code][c2.code - 'a'.code] = true
        break
      }
    }
    for (c in words[n - 1].toCharArray()) {
      if (cnt == 26) {
        break
      }
      (c -= 'a').toChar()
      if (!s[c.code]) {
        ++cnt
        s[c.code] = true
      }
    }
    val indegree = IntArray(26)
    for (i in 0..25) {
      for (j in 0..25) {
        if (i != j && s[i] && s[j] && g[i][j]) {
          ++indegree[j]
        }
      }
    }
    val q: Deque<Int> = LinkedList()
    for (i in 0..25) {
      if (s[i] && indegree[i] == 0) {
        q.offerLast(i)
      }
    }
    val ans = StringBuilder()
    while (!q.isEmpty()) {
      val t = q.pollFirst()
      ans.append((t + 'a'.code).toChar())
      for (i in 0..25) {
        if (i != t && s[i] && g[t][i]) {
          if (--indegree[i] == 0) {
            q.offerLast(i)
          }
        }
      }
    }
    return if (ans.length < cnt) "" else ans.toString()
  }
}
