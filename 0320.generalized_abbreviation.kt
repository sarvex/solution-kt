internal class Solution {
  fun generateAbbreviations(word: String): List<String> {
    val n = word.length
    val ans: List<String> = ArrayList()
    for (i in 0 until (1 shl n)) {
      val s = StringBuilder()
      var cnt = 0
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          ++cnt
        } else {
          if (cnt > 0) {
            s.append(cnt)
            cnt = 0
          }
          s.append(word[j])
        }
      }
      if (cnt > 0) {
        s.append(cnt)
      }
      ans.add(s.toString())
    }
    return ans
  }
}
