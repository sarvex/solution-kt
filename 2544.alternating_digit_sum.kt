class Solution {
  fun alternateDigitSum(n: Int): Int {
    var ans = 0
    var sign = 1
    for (c in n.toString().toCharArray()) {
      val x = c.code - '0'.code
      ans += sign * x
      sign *= -1
    }
    return ans
  }
}
