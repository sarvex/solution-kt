internal class Solution {
  fun findAnagrams(s: String, p: String): List<Int> {
    val m = s.length
    val n = p.length
    val ans: List<Int> = ArrayList()
    if (m < n) {
      return ans
    }
    val cnt1 = IntArray(26)
    for (i in 0 until n) {
      ++cnt1[p[i].code - 'a'.code]
    }
    val cnt2 = IntArray(26)
    for (i in 0 until n - 1) {
      ++cnt2[s[i].code - 'a'.code]
    }
    for (i in n - 1 until m) {
      ++cnt2[s[i].code - 'a'.code]
      if (Arrays.equals(cnt1, cnt2)) {
        ans.add(i - n + 1)
      }
      --cnt2[s[i - n + 1].code - 'a'.code]
    }
    return ans
  }
}
