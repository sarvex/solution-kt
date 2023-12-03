internal class Solution {
  fun majorityElement(nums: IntArray): List<Int> {
    var n1 = 0
    var n2 = 0
    var m1 = 0
    var m2 = 1
    for (m in nums) {
      if (m == m1) {
        ++n1
      } else if (m == m2) {
        ++n2
      } else if (n1 == 0) {
        m1 = m
        ++n1
      } else if (n2 == 0) {
        m2 = m
        ++n2
      } else {
        --n1
        --n2
      }
    }
    val ans: List<Int> = ArrayList()
    n1 = 0
    n2 = 0
    for (m in nums) {
      if (m == m1) {
        ++n1
      } else if (m == m2) {
        ++n2
      }
    }
    if (n1 > nums.size / 3) {
      ans.add(m1)
    }
    if (n2 > nums.size / 3) {
      ans.add(m2)
    }
    return ans
  }
}
