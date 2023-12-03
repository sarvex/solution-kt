internal class Solution {
  fun singleNumber(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (c in nums) {
      val aa = a.inv() and b and c or (a and b.inv() and c.inv())
      val bb = a.inv() and (b xor c)
      a = aa
      b = bb
    }
    return b
  }
}
