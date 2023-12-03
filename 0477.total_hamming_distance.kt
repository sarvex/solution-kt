internal class Solution {
  fun totalHammingDistance(nums: IntArray): Int {
    var ans = 0
    for (i in 0..30) {
      var a = 0
      var b = 0
      for (v in nums) {
        val t = v shr i and 1
        a += t
        b += t xor 1
      }
      ans += a * b
    }
    return ans
  }
}
