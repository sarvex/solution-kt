class Solution {
  fun partitionString(s: String): Int {
    var v = 0
    var ans = 1
    for (c in s.toCharArray()) {
      val i = c.code - 'a'.code
      if (v shr i and 1 == 1) {
        v = 0
        ++ans
      }
      v = v or (1 shl i)
    }
    return ans
  }
}
