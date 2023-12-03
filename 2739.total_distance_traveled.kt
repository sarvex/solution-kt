class Solution {
  fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
    var mainTank = mainTank
    var additionalTank = additionalTank
    var ans = 0
    var cur = 0
    while (mainTank > 0) {
      cur++
      ans += 10
      mainTank--
      if (cur % 5 == 0 && additionalTank > 0) {
        additionalTank--
        mainTank++
      }
    }
    return ans
  }
}
