class Solution {
  fun maximumNumberOfStringPairs(words: Array<String>): Int {
    val cnt: Map<String, Int> = HashMap(words.size)
    var ans = 0
    for (w in words) {
      ans += cnt[w] ?: 0
      cnt.merge(StringBuilder(w).reverse().toString(), 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
