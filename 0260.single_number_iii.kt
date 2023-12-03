internal class Solution {
  fun singleNumber(nums: IntArray): IntArray {
    var xs = 0
    for (x in nums) {
      xs = xs xor x
    }
    val lb = xs and -xs
    var a = 0
    for (x in nums) {
      if (x and lb != 0) {
        a = a xor x
      }
    }
    val b = xs xor a
    return intArrayOf(a, b)
  }
}
