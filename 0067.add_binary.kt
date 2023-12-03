internal class Solution {
  fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    while (i >= 0 || j >= 0 || carry > 0) {
      carry += (if (i >= 0) a[i].code - '0'.code else 0) + if (j >= 0) b[j].code - '0'.code else 0
      sb.append(carry % 2)
      carry /= 2
      --i
      --j
    }
    return sb.reverse().toString()
  }
}
