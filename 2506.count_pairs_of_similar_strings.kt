class Solution {
  fun similarPairs(words: Array<String>): Int {
    var ans = 0
    val cnt: Map<Int, Int> = HashMap()
    for (w in words) {
      var v = 0
      for (i in 0 until w.length) {
        v = v or (1 shl w[i].code - 'a'.code)
      }
      ans += cnt[v] ?: 0
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
    return ans
  }
}
