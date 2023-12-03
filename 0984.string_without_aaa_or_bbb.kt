class Solution {
  fun strWithout3a3b(a: Int, b: Int): String {
    var a = a
    var b = b
    val ans = StringBuilder()
    while (a > 0 && b > 0) {
      if (a > b) {
        ans.append("aab")
        a -= 2
        b -= 1
      } else if (a < b) {
        ans.append("bba")
        a -= 1
        b -= 2
      } else {
        ans.append("ab")
        --a
        --b
      }
    }
    if (a > 0) {
      ans.append("a".repeat(a))
    }
    if (b > 0) {
      ans.append("b".repeat(b))
    }
    return ans.toString()
  }
}
