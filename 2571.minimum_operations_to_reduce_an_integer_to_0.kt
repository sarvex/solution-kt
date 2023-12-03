class Solution {
  fun minOperations(n: Int): Int {
    var n = n
    var ans = 0
    var cnt = 0
    while (n > 0) {
      if (n and 1 == 1) {
        ++cnt
      } else if (cnt > 0) {
        ++ans
        cnt = if (cnt == 1) 0 else 1
      }
      n = n shr 1
    }
    ans += if (cnt == 1) 1 else 0
    ans += if (cnt > 1) 2 else 0
    return ans
  }
}
