class Solution {
  fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    val last = IntArray(26)
    val n = garbage.size
    var ans = 0
    for (i in 0 until n) {
      val k = garbage[i].length
      ans += k
      for (j in 0 until k) {
        last[garbage[i][j].code - 'A'.code] = i
      }
    }
    val m = travel.size
    val s = IntArray(m + 1)
    for (i in 0 until m) {
      s[i + 1] = s[i] + travel[i]
    }
    for (i in last) {
      ans += s[i]
    }
    return ans
  }
}
