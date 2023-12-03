class Solution {
  fun findTheArrayConcVal(nums: IntArray): Long {
    var ans: Long = 0
    var i = 0
    var j = nums.size - 1
    while (i < j) {
      ans += (nums[i].toString() + "" + nums[j]).toInt()
      ++i
      --j
    }
    if (i == j) {
      ans += nums[i].toLong()
    }
    return ans
  }
}
