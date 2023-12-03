class Solution {
  fun evaluate(s: String, knowledge: List<List<String?>>): String {
    val d: Map<String, String> = HashMap(knowledge.size())
    for (e in knowledge) {
      d.put(e[0], e[1])
    }
    val ans = StringBuilder()
    var i = 0
    while (i < s.length) {
      if (s[i] == '(') {
        val j = s.indexOf(')', i + 1)
        ans.append(d[s.substring(i + 1, j)] ?: "?")
        i = j
      } else {
        ans.append(s[i])
      }
      ++i
    }
    return ans.toString()
  }
}
