import kotlin.math.abs

internal class Solution {
  fun nearestPalindromic(n: String): String {
    val x = n.toLong()
    var ans: Long = -1
    for (t in get(n)) {
      if (ans == -1L || abs((t - x).toDouble()) < abs((ans - x).toDouble()) || abs((t - x).toDouble()) == abs((ans - x).toDouble()) && t < ans) {
        ans = t
      }
    }
    return ans.toString()
  }

  private operator fun get(n: String): Set<Long> {
    val l = n.length
    val res: Set<Long> = HashSet()
    res.add(10.pow((l - 1).toDouble()) as Long - 1)
    res.add(10.pow(l.toDouble()) as Long + 1)
    val left = n.substring(0, (l + 1) / 2).toLong()
    for (i in left - 1..left + 1) {
      val sb = StringBuilder()
      sb.append(i)
      sb.append(StringBuilder(i.toString() + "").reverse().substring(l and 1))
      res.add(sb.toString().toLong())
    }
    res.remove(n.toLong())
    return res
  }
}
