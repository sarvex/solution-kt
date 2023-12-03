internal class Solution {
  fun smallestRange(nums: List<List<Int>>): IntArray {
    var n = 0
    for (v in nums) {
      n += v.size()
    }
    val t = Array(n) { IntArray(2) }
    val k: Int = nums.size()
    run {
      var i = 0
      var j = 0
      while (i < k) {
        for (x in nums[i]) {
          t[j++] = intArrayOf(x, i)
        }
        ++i
      }
    }
    Arrays.sort(t) { a, b -> a.get(0) - b.get(0) }
    var j = 0
    val cnt: Map<Int, Int> = HashMap()
    val ans = intArrayOf(-1000000, 1000000)
    for (e in t) {
      val b = e[0]
      val v = e[1]
      cnt.put(v, (cnt[v] ?: 0) + 1)
      while (cnt.size() === k) {
        val a = t[j][0]
        val w = t[j][1]
        val x = b - a - (ans[1] - ans[0])
        if (x < 0 || x == 0 && a < ans[0]) {
          ans[0] = a
          ans[1] = b
        }
        cnt.put(w, cnt[w]!! - 1)
        if (cnt[w] === 0) {
          cnt.remove(w)
        }
        ++j
      }
    }
    return ans
  }
}
