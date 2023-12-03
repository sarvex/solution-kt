internal class Solution {
  fun uniqueLetterString(s: String): Int {
    val d: Array<List<Int>?> = arrayOfNulls(26)
    Arrays.setAll(d) { k -> ArrayList() }
    for (i in 0..25) {
      d[i].add(-1)
    }
    for (i in 0 until s.length) {
      d[s[i].code - 'A'.code].add(i)
    }
    var ans = 0
    for (v in d) {
      v.add(s.length)
      for (i in 1 until v!!.size() - 1) {
        ans += (v[i] - v[i - 1]) * (v[i + 1] - v[i])
      }
    }
    return ans
  }
}
