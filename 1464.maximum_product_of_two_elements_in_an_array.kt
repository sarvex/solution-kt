class Solution {
  fun maxProduct(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (v in nums) {
      if (v > a) {
        b = a
        a = v
      } else if (v > b) {
        b = v
      }
    }
    return (a - 1) * (b - 1)
  }
}
