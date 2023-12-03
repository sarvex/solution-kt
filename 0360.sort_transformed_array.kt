internal class Solution {
  fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
    val n = nums.size
    var i = 0
    var j = n - 1
    var k = if (a < 0) 0 else n - 1
    val res = IntArray(n)
    while (i <= j) {
      val v1 = f(a, b, c, nums[i])
      val v2 = f(a, b, c, nums[j])
      if (a < 0) {
        if (v1 <= v2) {
          res[k] = v1
          ++i
        } else {
          res[k] = v2
          --j
        }
        ++k
      } else {
        if (v1 >= v2) {
          res[k] = v1
          ++i
        } else {
          res[k] = v2
          --j
        }
        --k
      }
    }
    return res
  }

  private fun f(a: Int, b: Int, c: Int, x: Int): Int {
    return a * x * x + b * x + c
  }
}
