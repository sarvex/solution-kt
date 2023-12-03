class Solution {
  fun equalFrequency(word: String): Boolean {
    val cnt = IntArray(26)
    for (i in 0 until word.length) {
      ++cnt[word[i].code - 'a'.code]
    }
    for (i in 0..25) {
      if (cnt[i] > 0) {
        --cnt[i]
        var x = 0
        var ok = true
        for (v in cnt) {
          if (v == 0) {
            continue
          }
          if (x > 0 && v != x) {
            ok = false
            break
          }
          x = v
        }
        if (ok) {
          return true
        }
        ++cnt[i]
      }
    }
    return false
  }
}
