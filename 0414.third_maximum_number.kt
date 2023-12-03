internal class Solution {
  fun thirdMax(nums: IntArray): Int {
    var m1 = Long.MIN_VALUE
    var m2 = Long.MIN_VALUE
    var m3 = Long.MIN_VALUE
    for (num in nums) {
      if (num.toLong() == m1 || num.toLong() == m2 || num.toLong() == m3) {
        continue
      }
      if (num > m1) {
        m3 = m2
        m2 = m1
        m1 = num.toLong()
      } else if (num > m2) {
        m3 = m2
        m2 = num.toLong()
      } else if (num > m3) {
        m3 = num.toLong()
      }
    }
    return (if (m3 != Long.MIN_VALUE) m3 else m1).toInt()
  }
}
