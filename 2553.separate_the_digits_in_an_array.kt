class Solution {
  fun separateDigits(nums: IntArray): IntArray {
    val res: List<Int> = ArrayList()
    for (x in nums) {
      val t: List<Int> = ArrayList()
      while (x > 0) {
        t.add(x % 10)
        x /= 10
      }
      Collections.reverse(t)
      res.addAll(t)
    }
    val ans = IntArray(res.size())
    for (i in ans.indices) {
      ans[i] = res[i]
    }
    return ans
  }
}
