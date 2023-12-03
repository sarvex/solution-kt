class Solution {
  fun wonderfulSubstrings(word: String): Long {
    val cnt = IntArray(1 shl 10)
    cnt[0] = 1
    var ans: Long = 0
    var st = 0
    for (c in word.toCharArray()) {
      st = st xor (1 shl c.code - 'a'.code)
      ans += cnt[st].toLong()
      for (i in 0..9) {
        ans += cnt[st xor (1 shl i)].toLong()
      }
      ++cnt[st]
    }
    return ans
  }
}
