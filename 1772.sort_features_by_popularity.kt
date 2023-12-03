class Solution {
  fun sortFeatures(features: Array<String>, responses: Array<String>): Array<String?> {
    val cnt: Map<String, Int> = HashMap()
    for (r in responses) {
      val ws: Set<String> = HashSet()
      for (w in r.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
        ws.add(w)
      }
      for (w in ws) {
        cnt.put(w, (cnt[w] ?: 0) + 1)
      }
    }
    val n = features.size
    val idx = arrayOfNulls<Int>(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j ->
      val d = (cnt[features[j]] ?: 0) - (cnt[features[i]] ?: 0)
      if (d == 0) i - j else d
    }
    val ans = arrayOfNulls<String>(n)
    for (i in 0 until n) {
      ans[i] = features[idx[i]!!]
    }
    return ans
  }
}
