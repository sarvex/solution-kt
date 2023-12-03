internal class Solution {
  fun longestPalindrome(words: Array<String>): Int {
    val cnt: Map<String, Int> = HashMap()
    for (w in words) {
      cnt.put(w, (cnt[w] ?: 0) + 1)
    }
    var ans = 0
    var x = 0
    for (e in cnt.entrySet()) {
      val k: Unit = e.getKey()
      val rk: String = StringBuilder(k).reverse().toString()
      val v: Int = e.getValue()
      if (k.charAt(0) === k.charAt(1)) {
        x += v and 1
        ans += v / 2 * 2 * 2
      } else {
        ans += Math.min(v, cnt[rk] ?: 0) * 2
      }
    }
    ans += if (x > 0) 2 else 0
    return ans
  }
}
