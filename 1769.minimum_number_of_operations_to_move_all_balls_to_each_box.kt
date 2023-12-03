class Solution {
  fun minOperations(boxes: String): IntArray {
    val n = boxes.length
    val ans = IntArray(n)
    run {
      var i = 1
      var cnt = 0
      while (i < n) {
        if (boxes[i - 1] == '1') {
          ++cnt
        }
        ans[i] = ans[i - 1] + cnt
        ++i
      }
    }
    var i = n - 2
    var cnt = 0
    var s = 0
    while (i >= 0) {
      if (boxes[i + 1] == '1') {
        ++cnt
      }
      s += cnt
      ans[i] += s
      --i
    }
    return ans
  }
}
