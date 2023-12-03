class Solution {
  fun getKth(lo: Int, hi: Int, k: Int): Int {
    val nums = arrayOfNulls<Int>(hi - lo + 1)
    for (i in lo..hi) {
      nums[i - lo] = i
    }
    Arrays.sort(nums) { a, b ->
      val fa = f(a)
      val fb = f(b)
      if (fa == fb) a - b else fa - fb
    }
    return nums[k - 1]!!
  }

  private fun f(x: Int): Int {
    var x = x
    var ans = 0
    while (x != 1) {
      if (x % 2 == 0) {
        x /= 2
      } else {
        x = x * 3 + 1
      }
      ++ans
    }
    return ans
  }
}
