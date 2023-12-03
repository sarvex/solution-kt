class Solution {
  fun strongPasswordCheckerII(password: String): Boolean {
    if (password.length < 8) {
      return false
    }
    var mask = 0
    for (i in 0 until password.length) {
      val c = password[i]
      if (i > 0 && c == password[i - 1]) {
        return false
      }
      mask = if (Character.isLowerCase(c)) {
        mask or 1
      } else if (Character.isUpperCase(c)) {
        mask or 2
      } else if (Character.isDigit(c)) {
        mask or 4
      } else {
        mask or 8
      }
    }
    return mask == 15
  }
}
