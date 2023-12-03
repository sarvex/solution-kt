class Solution {
  fun numberOfSteps(num: Int): Int {
    var num = num
    var ans = 0
    while (num != 0) {
      num = if (num and 1 == 1) num - 1 else num shr 1
      ++ans
    }
    return ans
  }
}
