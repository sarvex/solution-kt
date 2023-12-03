internal class Solution {
  private var n = 0
  private var nums: IntArray
  fun circularArrayLoop(nums: IntArray): Boolean {
    n = nums.size
    this.nums = nums
    for (i in 0 until n) {
      if (nums[i] == 0) {
        continue
      }
      var slow = i
      var fast = next(i)
      while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast)] > 0) {
        if (slow == fast) {
          if (slow != next(slow)) {
            return true
          }
          break
        }
        slow = next(slow)
        fast = next(next(fast))
      }
      var j = i
      while (nums[j] * nums[next(j)] > 0) {
        nums[j] = 0
        j = next(j)
      }
    }
    return false
  }

  private fun next(i: Int): Int {
    return (i + nums[i] % n + n) % n
  }
}
