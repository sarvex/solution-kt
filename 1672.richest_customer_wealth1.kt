import kotlin.math.max

class Solution {
  fun maximumWealth(accounts: Array<IntArray>): Int {
    var ans = 0
    for (e in accounts) {
      // int s = Arrays.stream(e).sum();
      var s = 0
      for (v in e) {
        s += v
      }
      ans = max(ans.toDouble(), s.toDouble()).toInt()
    }
    return ans
  }
}
