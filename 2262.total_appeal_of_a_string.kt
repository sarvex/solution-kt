class Solution {
  fun appealSum(s: String): Long {
    var ans: Long = 0
    var t: Long = 0
    val pos = IntArray(26)
    Arrays.fill(pos, -1)
    for (i in 0 until s.length) {
      val c = s[i].code - 'a'.code
      t += (i - pos[c]).toLong()
      ans += t
      pos[c] = i
    }
    return ans
  }
}
