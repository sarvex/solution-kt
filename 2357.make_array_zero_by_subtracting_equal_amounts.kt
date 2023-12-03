class Solution {
  fun minimumOperations(nums: IntArray): Int {
    val s = BooleanArray(101)
    s[0] = true
    var ans = 0
    for (x in nums) {
      if (!s[x]) {
        ++ans
        s[x] = true
      }
    }
    return ans
  }
}
