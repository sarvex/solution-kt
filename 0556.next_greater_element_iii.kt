internal class Solution {
  fun nextGreaterElement(n: Int): Int {
    var n = n
    val cs = n.toString().toCharArray()
    n = cs.size
    var i = n - 2
    var j = n - 1
    while (i >= 0 && cs[i] >= cs[i + 1]) {
      --i
    }
    if (i < 0) {
      return -1
    }
    while (cs[i] >= cs[j]) {
      --j
    }
    swap(cs, i, j)
    reverse(cs, i + 1, n - 1)
    val ans = String(cs).toLong()
    return if (ans > Int.MAX_VALUE) -1 else ans.toInt()
  }

  private fun swap(cs: CharArray, i: Int, j: Int) {
    val t = cs[i]
    cs[i] = cs[j]
    cs[j] = t
  }

  private fun reverse(cs: CharArray, i: Int, j: Int) {
    var i = i
    var j = j
    while (i < j) {
      swap(cs, i, j)
      ++i
      --j
    }
  }
}
