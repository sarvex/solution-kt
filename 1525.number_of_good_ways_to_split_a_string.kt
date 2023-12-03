class Solution {
  fun numSplits(s: String): Int {
    val cnt: Map<Char, Int> = HashMap()
    for (c in s.toCharArray()) {
      cnt.merge(c, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val vis: Set<Char> = HashSet()
    var ans = 0
    for (c in s.toCharArray()) {
      vis.add(c)
      if (cnt.merge(c, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(c)
      }
      if (vis.size() === cnt.size()) {
        ++ans
      }
    }
    return ans
  }
}
