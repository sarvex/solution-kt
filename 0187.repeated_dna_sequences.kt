internal class Solution {
  fun findRepeatedDnaSequences(s: String): List<String> {
    val cnt: Map<String, Int> = HashMap()
    val ans: List<String> = ArrayList()
    for (i in 0 until s.length - 10 + 1) {
      val t = s.substring(i, i + 10)
      if (cnt.merge(t, 1) { a: Int, b: Int -> Integer.sum(a, b) } === 2) {
        ans.add(t)
      }
    }
    return ans
  }
}
