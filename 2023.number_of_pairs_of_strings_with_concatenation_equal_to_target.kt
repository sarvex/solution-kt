internal class Solution {
  fun numOfPairs(nums: Array<String>, target: String): Int {
    val cnt: Map<String, Int> = HashMap()
    for (x in nums) {
      cnt.put(x, (cnt[x] ?: 0) + 1)
    }
    var ans = 0
    for (i in 1 until target.length) {
      val a = target.substring(0, i)
      val b = target.substring(i)
      val x = cnt[a] ?: 0
      val y = cnt[b] ?: 0
      ans += if (a != b) {
        x * y
      } else {
        x * (y - 1)
      }
    }
    return ans
  }
}
