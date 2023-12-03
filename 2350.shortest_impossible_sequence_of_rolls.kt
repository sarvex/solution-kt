class Solution {
  fun shortestSequence(rolls: IntArray, k: Int): Int {
    val s: Set<Int> = HashSet()
    var ans = 1
    for (v in rolls) {
      s.add(v)
      if (s.size() === k) {
        s.clear()
        ++ans
      }
    }
    return ans
  }
}
