internal class Solution {
  fun maxDepthAfterSplit(seq: String): IntArray {
    val n = seq.length
    val ans = IntArray(n)
    var i = 0
    var x = 0
    while (i < n) {
      if (seq[i] == '(') {
        ans[i] = x++ and 1
      } else {
        ans[i] = --x and 1
      }
      ++i
    }
    return ans
  }
}
