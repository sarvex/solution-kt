internal class Solution {
  fun intToRoman(num: Int): String {
    var num = num
    val cs: List<String> = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val vs: List<Int> = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val ans = StringBuilder()
    var i = 0
    val n: Int = cs.size()
    while (i < n) {
      while (num >= vs[i]) {
        num -= vs[i]
        ans.append(cs[i])
      }
      ++i
    }
    return ans.toString()
  }
}
