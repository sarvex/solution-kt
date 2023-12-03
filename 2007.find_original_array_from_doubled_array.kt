internal class Solution {
  fun findOriginalArray(changed: IntArray): IntArray {
    val n = changed.size
    if (n % 2 == 1) {
      return intArrayOf()
    }
    Arrays.sort(changed)
    val cnt = IntArray(changed[n - 1] + 1)
    for (x in changed) {
      ++cnt[x]
    }
    val ans = IntArray(n / 2)
    var i = 0
    for (x in changed) {
      if (cnt[x] == 0) {
        continue
      }
      if (x * 2 >= cnt.size || cnt[x * 2] <= 0) {
        return intArrayOf()
      }
      ans[i++] = x
      cnt[x]--
      cnt[x * 2]--
    }
    return if (i == n / 2) ans else intArrayOf()
  }
}
