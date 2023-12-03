internal class Solution {
  fun prefixesDivBy5(nums: IntArray): List<Boolean> {
    val ans: List<Boolean> = ArrayList()
    var x = 0
    for (v in nums) {
      x = (x shl 1 or v) % 5
      ans.add(x == 0)
    }
    return ans
  }
}
