class Solution {
  fun brokenCalc(startValue: Int, target: Int): Int {
    var target = target
    var ans = 0
    while (startValue < target) {
      if (target and 1 == 1) {
        target++
      } else {
        target = target shr 1
      }
      ans += 1
    }
    ans += startValue - target
    return ans
  }
}
