internal class Solution {
  fun distributeCandies(candyType: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (c in candyType) {
      s.add(c)
    }
    return Math.min(candyType.size shr 1, s.size())
  }
}
