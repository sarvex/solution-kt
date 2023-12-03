class Solution {
  fun countDistinct(s: String): Int {
    val ss: Set<String> = HashSet()
    val n = s.length
    for (i in 0 until n) {
      for (j in i + 1..n) {
        ss.add(s.substring(i, j))
      }
    }
    return ss.size()
  }
}
