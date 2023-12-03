class Solution {
  fun maximumXOR(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      ans = ans or x
    }
    return ans
  }
}
