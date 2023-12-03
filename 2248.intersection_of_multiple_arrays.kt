class Solution {
  fun intersection(nums: Array<IntArray>): List<Int> {
    val cnt = IntArray(1001)
    for (arr in nums) {
      for (x in arr) {
        ++cnt[x]
      }
    }
    val ans: List<Int> = ArrayList()
    for (x in 0..1000) {
      if (cnt[x] == nums.size) {
        ans.add(x)
      }
    }
    return ans
  }
}
