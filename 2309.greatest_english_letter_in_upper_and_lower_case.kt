class Solution {
  fun greatestLetter(s: String): String {
    var mask1 = 0
    var mask2 = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (Character.isLowerCase(c)) {
        mask1 = mask1 or (1 shl c.code - 'a'.code)
      } else {
        mask2 = mask2 or (1 shl c.code - 'A'.code)
      }
    }
    val mask = mask1 and mask2
    return if (mask > 0) (31 - Integer.numberOfLeadingZeros(mask) + 'A'.code).toChar().toString() else ""
  }
}
