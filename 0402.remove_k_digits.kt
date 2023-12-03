internal class Solution {
  fun removeKdigits(num: String, k: Int): String {
    var k = k
    val stk = StringBuilder()
    for (c in num.toCharArray()) {
      while (k > 0 && stk.length > 0 && stk[stk.length - 1] > c) {
        stk.deleteCharAt(stk.length - 1)
        --k
      }
      stk.append(c)
    }
    while (k > 0) {
      stk.deleteCharAt(stk.length - 1)
      --k
    }
    var i = 0
    while (i < stk.length && stk[i] == '0') {
      ++i
    }
    val ans = stk.substring(i)
    return if ("" == ans) "0" else ans
  }
}
