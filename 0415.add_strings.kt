internal class Solution {
  fun addStrings(num1: String, num2: String): String {
    var i = num1.length - 1
    var j = num2.length - 1
    val ans = StringBuilder()
    var c = 0
    while (i >= 0 || j >= 0 || c > 0) {
      val a = if (i < 0) 0 else num1[i].code - '0'.code
      val b = if (j < 0) 0 else num2[j].code - '0'.code
      c += a + b
      ans.append(c % 10)
      c /= 10
      --i
      --j
    }
    return ans.reverse().toString()
  }

  fun subStrings(num1: String, num2: String): String {
    var num1 = num1
    var num2 = num2
    val m = num1.length
    val n = num2.length
    val neg = m < n || m == n && num1.compareTo(num2) < 0
    if (neg) {
      val t = num1
      num1 = num2
      num2 = t
    }
    var i = num1.length - 1
    var j = num2.length - 1
    val ans = StringBuilder()
    var c = 0
    while (i >= 0) {
      c = num1[i].code - '0'.code - c - if (j < 0) 0 else num2[j].code - '0'.code
      ans.append((c + 10) % 10)
      c = if (c < 0) 1 else 0
      --i
      --j
    }
    while (ans.length > 1 && ans[ans.length - 1] == '0') {
      ans.deleteCharAt(ans.length - 1)
    }
    if (neg) {
      ans.append('-')
    }
    return ans.reverse().toString()
  }
}
