internal class Solution {
  fun findErrorNums(nums: IntArray): IntArray {
    val n = nums.size
    var xs = 0
    for (i in 1..n) {
      xs = xs xor (i xor nums[i - 1])
    }
    val lb = xs and -xs
    var a = 0
    for (i in 1..n) {
      if (i and lb > 0) {
        a = a xor i
      }
      if (nums[i - 1] and lb > 0) {
        a = a xor nums[i - 1]
      }
    }
    val b = xs xor a
    for (i in 0 until n) {
      if (nums[i] == a) {
        return intArrayOf(a, b)
      }
    }
    return intArrayOf(b, a)
  }
}
