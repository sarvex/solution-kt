class Solution {
  fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
    val m = (n shl 1) + 10
    val d = LongArray(m)
    val cnt = LongArray(m)
    cnt[1] = 1
    for (i in 1..n) {
      if (cnt[i] > 0) {
        d[i] = (d[i] + cnt[i]) % Solution.Companion.MOD
        d[i + forget] = (d[i + forget] - cnt[i] + Solution.Companion.MOD) % Solution.Companion.MOD
        var nxt = i + delay
        while (nxt < i + forget) {
          cnt[nxt] = (cnt[nxt] + cnt[i]) % Solution.Companion.MOD
          ++nxt
        }
      }
    }
    var ans: Long = 0
    for (i in 1..n) {
      ans = (ans + d[i]) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
