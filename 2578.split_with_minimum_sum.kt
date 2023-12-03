class Solution {
  fun splitNum(num: Int): Int {
    var num = num
    val cnt = IntArray(10)
    var n = 0
    while (num > 0) {
      ++cnt[num % 10]
      ++n
      num /= 10
    }
    val ans = IntArray(2)
    var i = 0
    var j = 0
    while (i < n) {
      while (cnt[j] == 0) {
        ++j
      }
      --cnt[j]
      ans[i and 1] = ans[i and 1] * 10 + j
      ++i
    }
    return ans[0] + ans[1]
  }
}
