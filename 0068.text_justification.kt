internal class Solution {
  fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val ans: List<String> = ArrayList()
    var i = 0
    val n = words.size
    while (i < n) {
      val t: List<String> = ArrayList()
      t.add(words[i])
      var cnt = words[i].length
      ++i
      while (i < n && cnt + 1 + words[i].length <= maxWidth) {
        cnt += 1 + words[i].length
        t.add(words[i++])
      }
      if (i == n || t.size() === 1) {
        val left = java.lang.String.join(" ", t)
        val right = " ".repeat(maxWidth - left.length)
        ans.add(left + right)
        continue
      }
      val spaceWidth: Int = maxWidth - (cnt - t.size() + 1)
      val w: Int = spaceWidth / (t.size() - 1)
      val m: Int = spaceWidth % (t.size() - 1)
      val row = StringBuilder()
      for (j in 0 until t.size() - 1) {
        row.append(t[j])
        row.append(" ".repeat(w + if (j < m) 1 else 0))
      }
      row.append(t[t.size() - 1])
      ans.add(row.toString())
    }
    return ans
  }
}
