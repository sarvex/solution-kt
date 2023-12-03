internal class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val m: Map<Int, Int> = HashMap()
    var i = 0
    while (true) {
      val x = nums[i]
      val y = target - x
      if (m.containsKey(y)) {
        return intArrayOf(m[y]!!, i)
      }
      m.put(x, i)
      ++i
    }
  }
}
