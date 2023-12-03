internal class Solution {
  fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray? {
    var s1 = 0
    var s2 = 0
    val s: Set<Int> = HashSet()
    for (a in aliceSizes) {
      s1 += a
    }
    for (b in bobSizes) {
      s.add(b)
      s2 += b
    }
    val diff = s1 - s2 shr 1
    for (a in aliceSizes) {
      val target = a - diff
      if (s.contains(target)) {
        return intArrayOf(a, target)
      }
    }
    return null
  }
}
