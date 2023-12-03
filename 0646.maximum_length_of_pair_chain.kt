internal class Solution {
  fun findLongestChain(pairs: Array<IntArray>): Int {
    Arrays.sort(pairs, Comparator.comparingInt { a -> a.get(1) })
    var ans = 0
    var cur = Int.MIN_VALUE
    for (p in pairs) {
      if (cur < p[0]) {
        cur = p[1]
        ++ans
      }
    }
    return ans
  }
}
