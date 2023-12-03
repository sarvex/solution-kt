class Solution {
  fun addMinimum(word: String): Int {
    val s = "abc"
    var ans = 0
    val n = word.length
    var i = 0
    var j = 0
    while (j < n) {
      if (word[j] != s[i]) {
        ++ans
      } else {
        ++j
      }
      i = (i + 1) % 3
    }
    if (word[n - 1] != 'c') {
      ans += if (word[n - 1] == 'b') 1 else 2
    }
    return ans
  }
}
