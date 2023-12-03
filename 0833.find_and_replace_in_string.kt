internal class Solution {
  fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String?>): String {
    val n = s.length
    val d = IntArray(n)
    Arrays.fill(d, -1)
    for (k in indices.indices) {
      val i = indices[k]
      if (s.startsWith(sources[k], i)) {
        d[i] = k
      }
    }
    val ans = StringBuilder()
    var i = 0
    while (i < n) {
      if (d[i] >= 0) {
        ans.append(targets[d[i]])
        i += sources[d[i]].length
      } else {
        ans.append(s[i++])
      }
    }
    return ans.toString()
  }
}
