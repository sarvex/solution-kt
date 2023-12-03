class Solution {
  fun waysToMakeFair(nums: IntArray): Int {
    var s1 = 0
    var s2 = 0
    val n = nums.size
    for (i in 0 until n) {
      s1 += if (i % 2 == 0) nums[i] else 0
      s2 += if (i % 2 == 1) nums[i] else 0
    }
    var t1 = 0
    var t2 = 0
    var ans = 0
    for (i in 0 until n) {
      val v = nums[i]
      ans += if (i % 2 == 0 && t2 + s1 - t1 - v == t1 + s2 - t2) 1 else 0
      ans += if (i % 2 == 1 && t2 + s1 - t1 == t1 + s2 - t2 - v) 1 else 0
      t1 += if (i % 2 == 0) v else 0
      t2 += if (i % 2 == 1) v else 0
    }
    return ans
  }
}
