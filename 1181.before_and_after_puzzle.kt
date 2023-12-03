internal class Solution {
  fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {
    val n = phrases.size
    val ps: Array<Array<String>> = arrayOfNulls(n)
    for (i in 0 until n) {
      val ws = phrases[i].split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      ps[i] = arrayOf(ws[0], ws[ws.size - 1])
    }
    val s: Set<String> = HashSet()
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i != j && ps[i][1] == ps[j][0]) {
          s.add(phrases[i] + phrases[j].substring(ps[j][0].length))
        }
      }
    }
    val ans = ArrayList(s)
    Collections.sort(ans)
    return ans
  }
}
