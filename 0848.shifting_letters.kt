internal class Solution {
  fun shiftingLetters(s: String, shifts: IntArray): String {
    val cs = s.toCharArray()
    val n = cs.size
    var t: Long = 0
    for (i in n - 1 downTo 0) {
      t += shifts[i].toLong()
      val j = ((cs[i].code - 'a'.code + t) % 26).toInt()
      cs[i] = ('a'.code + j).toChar()
    }
    return String(cs)
  }
}
