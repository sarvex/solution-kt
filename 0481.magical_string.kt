internal class Solution {
  fun magicalString(n: Int): Int {
    val s: List<Int> = ArrayList(Arrays.asList(1, 2, 2))
    run {
      var i = 2
      while (s.size() < n) {
        val pre = s[s.size() - 1]
        val cur = 3 - pre
        for (j in 0 until s[i]) {
          s.add(cur)
        }
        ++i
      }
    }
    var ans = 0
    for (i in 0 until n) {
      if (s[i] === 1) {
        ++ans
      }
    }
    return ans
  }
}
