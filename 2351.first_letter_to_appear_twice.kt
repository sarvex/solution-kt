class Solution {
  fun repeatedCharacter(s: String): Char {
    var mask = 0
    var i = 0
    while (true) {
      val c = s[i]
      if (mask shr c.code - 'a'.code and 1 == 1) {
        return c
      }
      mask = mask or (1 shl c.code - 'a'.code)
      ++i
    }
  }
}
