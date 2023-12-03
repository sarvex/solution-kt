class Solution {
  fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
    val n = nums.size
    val s: Set<String> = HashSet()
    for (i in 0 until n) {
      var cnt = 0
      var t = ""
      for (j in i until n) {
        if (nums[j] % p == 0 && ++cnt > k) {
          break
        }
        t += nums[j].toString() + ","
        s.add(t)
      }
    }
    return s.size()
  }
}
