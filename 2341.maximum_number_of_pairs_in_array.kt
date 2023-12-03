class Solution {
  fun numberOfPairs(nums: IntArray): IntArray {
    val cnt = IntArray(101)
    for (x in nums) {
      ++cnt[x]
    }
    var s = 0
    for (v in cnt) {
      s += v / 2
    }
    return intArrayOf(s, nums.size - s * 2)
  }
}
