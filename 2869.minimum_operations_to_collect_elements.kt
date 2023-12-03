class Solution {
  fun minOperations(nums: List<Int>, k: Int): Int {
    val isAdded = BooleanArray(k)
    val n: Int = nums.size()
    var count = 0
    var i = n - 1
    while (true) {
      if (nums[i] > k || isAdded[nums[i] - 1]) {
        i--
        continue
      }
      isAdded[nums[i] - 1] = true
      count++
      if (count == k) {
        return n - i
      }
      i--
    }
  }
}
