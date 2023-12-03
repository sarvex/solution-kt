class Solution {
  fun mostFrequent(nums: IntArray, key: Int): Int {
    val cnt = IntArray(1001)
    var ans = 0
    var mx = 0
    for (i in 0 until nums.size - 1) {
      if (nums[i] == key) {
        if (mx < ++cnt[nums[i + 1]]) {
          mx = cnt[nums[i + 1]]
          ans = nums[i + 1]
        }
      }
    }
    return ans
  }
}
