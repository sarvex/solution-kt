internal class Solution {
  fun pathInZigZagTree(label: Int): List<Int> {
    var label = label
    var x = 1
    var i = 1
    while (x shl 1 <= label) {
      x = x shl 1
      ++i
    }
    val ans: List<Int> = ArrayList()
    while (i > 0) {
      ans.add(label)
      label = (1 shl i - 1) + (1 shl i) - 1 - label shr 1
      --i
    }
    Collections.reverse(ans)
    return ans
  }
}
