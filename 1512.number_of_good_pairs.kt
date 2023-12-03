class Solution {
  fun numIdenticalPairs(nums: IntArray): Int {
    var ans = 0
    val cnt = IntArray(101)
    for (x in nums) {
      ans += cnt[x]++
    }
    return ans
  }
}
