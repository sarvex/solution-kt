class Solution {
  fun findDifferentBinaryString(nums: Array<String>): String {
    var mask = 0
    for (x in nums) {
      var cnt = 0
      for (i in 0 until x.length) {
        if (x[i] == '1') {
          ++cnt
        }
      }
      mask = mask or (1 shl cnt)
    }
    var i = 0
    while (true) {
      if (mask shr i and 1 == 0) {
        return "1".repeat(i) + "0".repeat(nums.size - i)
      }
      ++i
    }
  }
}
