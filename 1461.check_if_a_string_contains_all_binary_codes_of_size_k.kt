class Solution {
  fun hasAllCodes(s: String, k: Int): Boolean {
    val n = s.length
    if (n - k + 1 < 1 shl k) {
      return false
    }
    val vis = BooleanArray(1 shl k)
    var num = s.substring(0, k).toInt(2)
    vis[num] = true
    for (i in k until n) {
      val a = s[i - k].code - '0'.code shl k - 1
      val b = s[i].code - '0'.code
      num = num - a shl 1 or b
      vis[num] = true
    }
    for (v in vis) {
      if (!v) {
        return false
      }
    }
    return true
  }
}
