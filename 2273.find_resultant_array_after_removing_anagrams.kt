class Solution {
  fun removeAnagrams(words: Array<String>): List<String> {
    val ans: List<String> = ArrayList()
    var prev = ""
    for (w in words) {
      val cs = w.toCharArray()
      Arrays.sort(cs)
      val t = String(cs)
      if (t != prev) {
        ans.add(w)
      }
      prev = t
    }
    return ans
  }
}
