class Solution {
  fun countLargestGroup(n: Int): Int {
    val cnt = IntArray(40)
    var ans = 0
    var mx = 0
    for (i in 1..n) {
      var s = 0
      var x = i
      while (x > 0) {
        s += x % 10
        x /= 10
      }
      ++cnt[s]
      if (mx < cnt[s]) {
        mx = cnt[s]
        ans = 1
      } else if (mx == cnt[s]) {
        ++ans
      }
    }
    return ans
  }
}
