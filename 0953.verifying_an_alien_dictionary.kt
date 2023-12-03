class Solution {
  fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val m = IntArray(26)
    for (i in 0..25) {
      m[order[i].code - 'a'.code] = i
    }
    for (i in 0..19) {
      var prev = -1
      var valid = true
      for (x in words) {
        val curr = if (i >= x.length) -1 else m[x[i].code - 'a'.code]
        if (prev > curr) {
          return false
        }
        if (prev == curr) {
          valid = false
        }
        prev = curr
      }
      if (valid) {
        break
      }
    }
    return true
  }
}
