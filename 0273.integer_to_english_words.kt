internal class Solution {
  fun numberToWords(num: Int): String {
    var num = num
    if (num == 0) {
      return "Zero"
    }
    val sb = StringBuilder()
    var i = 1000000000
    while (i >= 1000) {
      if (num >= i) {
        sb.append(get3Digits(num / i)).append(' ').append(Solution.Companion.map.get(i))
        num %= i
      }
      i /= 1000
    }
    if (num > 0) {
      sb.append(get3Digits(num))
    }
    return sb.substring(1)
  }

  private fun get3Digits(num: Int): String {
    var num = num
    val sb = StringBuilder()
    if (num >= 100) {
      sb.append(' ').append(Solution.Companion.map.get(num / 100)).append(' ').append(Solution.Companion.map.get(100))
      num %= 100
    }
    if (num > 0) {
      if (num < 20 || num % 10 == 0) {
        sb.append(' ').append(Solution.Companion.map.get(num))
      } else {
        sb.append(' ').append(Solution.Companion.map.get(num / 10 * 10)).append(' ')
          .append(Solution.Companion.map.get(num % 10))
      }
    }
    return sb.toString()
  }

  companion object {
    private val map: Map<Int, String>? = null

    init {
      Solution.Companion.map = HashMap()
      Solution.Companion.map.put(1, "One")
      Solution.Companion.map.put(2, "Two")
      Solution.Companion.map.put(3, "Three")
      Solution.Companion.map.put(4, "Four")
      Solution.Companion.map.put(5, "Five")
      Solution.Companion.map.put(6, "Six")
      Solution.Companion.map.put(7, "Seven")
      Solution.Companion.map.put(8, "Eight")
      Solution.Companion.map.put(9, "Nine")
      Solution.Companion.map.put(10, "Ten")
      Solution.Companion.map.put(11, "Eleven")
      Solution.Companion.map.put(12, "Twelve")
      Solution.Companion.map.put(13, "Thirteen")
      Solution.Companion.map.put(14, "Fourteen")
      Solution.Companion.map.put(15, "Fifteen")
      Solution.Companion.map.put(16, "Sixteen")
      Solution.Companion.map.put(17, "Seventeen")
      Solution.Companion.map.put(18, "Eighteen")
      Solution.Companion.map.put(19, "Nineteen")
      Solution.Companion.map.put(20, "Twenty")
      Solution.Companion.map.put(30, "Thirty")
      Solution.Companion.map.put(40, "Forty")
      Solution.Companion.map.put(50, "Fifty")
      Solution.Companion.map.put(60, "Sixty")
      Solution.Companion.map.put(70, "Seventy")
      Solution.Companion.map.put(80, "Eighty")
      Solution.Companion.map.put(90, "Ninety")
      Solution.Companion.map.put(100, "Hundred")
      Solution.Companion.map.put(1000, "Thousand")
      Solution.Companion.map.put(1000000, "Million")
      Solution.Companion.map.put(1000000000, "Billion")
    }
  }
}
