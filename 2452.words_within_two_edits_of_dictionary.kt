class Solution {
  fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
    val ans: List<String> = ArrayList()
    val n = queries[0].length
    for (s in queries) {
      for (t in dictionary) {
        var cnt = 0
        for (i in 0 until n) {
          if (s[i] != t[i]) {
            ++cnt
          }
        }
        if (cnt < 3) {
          ans.add(s)
          break
        }
      }
    }
    return ans
  }
}
