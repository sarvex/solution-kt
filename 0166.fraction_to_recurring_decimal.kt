import kotlin.math.abs

internal class Solution {
  fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) {
      return "0"
    }
    val sb = StringBuilder()
    val neg = (numerator > 0) xor (denominator > 0)
    sb.append(if (neg) "-" else "")
    var num = abs(numerator.toLong().toDouble()).toLong()
    val d = abs(denominator.toLong().toDouble()).toLong()
    sb.append(num / d)
    num %= d
    if (num == 0L) {
      return sb.toString()
    }
    sb.append(".")
    val mp: Map<Long, Int> = HashMap()
    while (num != 0L) {
      mp.put(num, sb.length)
      num *= 10
      sb.append(num / d)
      num %= d
      if (mp.containsKey(num)) {
        val idx = mp[num]!!
        sb.insert(idx, "(")
        sb.append(")")
        break
      }
    }
    return sb.toString()
  }
}
