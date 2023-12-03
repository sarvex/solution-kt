class Solution {
  fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val vowels: Set<Char> = Set.of('a', 'e', 'i', 'o', 'u')
    val n = words.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      val a = words[i][0]
      val b = words[i][words[i].length - 1]
      s[i + 1] = s[i] + if (vowels.contains(a) && vowels.contains(b)) 1 else 0
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val l = queries[i][0]
      val r = queries[i][1]
      ans[i] = s[r + 1] - s[l]
    }
    return ans
  }
}
