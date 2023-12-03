class Solution {
  fun decompressRLElist(nums: IntArray): IntArray {
    var n = 0
    run {
      var i = 0
      while (i < nums.size) {
        n += nums[i]
        i += 2
      }
    }
    val res = IntArray(n)
    var i = 1
    var k = 0
    while (i < nums.size) {
      for (j in 0 until nums[i - 1]) {
        res[k++] = nums[i]
      }
      i += 2
    }
    return res
  }
}
