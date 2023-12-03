class Solution {
  fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
    var xs = 0
    for (x in nums) {
      xs = xs xor x
    }
    val mask = (1 shl maximumBit) - 1
    val n = nums.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      val x = nums[n - i - 1]
      val k = xs xor mask
      ans[i] = k
      xs = xs xor x
    }
    return ans
  }
}
