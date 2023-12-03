internal class Solution {
  fun originalDigits(s: String): String {
    val counter = IntArray(26)
    for (c in s.toCharArray()) {
      ++counter[c.code - 'a'.code]
    }
    val cnt = IntArray(10)
    cnt[0] = counter['z'.code - 'a'.code]
    cnt[2] = counter['w'.code - 'a'.code]
    cnt[4] = counter['u'.code - 'a'.code]
    cnt[6] = counter['x'.code - 'a'.code]
    cnt[8] = counter['g'.code - 'a'.code]
    cnt[3] = counter['h'.code - 'a'.code] - cnt[8]
    cnt[5] = counter['f'.code - 'a'.code] - cnt[4]
    cnt[7] = counter['s'.code - 'a'.code] - cnt[6]
    cnt[1] = counter['o'.code - 'a'.code] - cnt[0] - cnt[2] - cnt[4]
    cnt[9] = counter['i'.code - 'a'.code] - cnt[5] - cnt[6] - cnt[8]
    val sb = StringBuilder()
    for (i in 0..9) {
      for (j in 0 until cnt[i]) {
        sb.append(i)
      }
    }
    return sb.toString()
  }
}
