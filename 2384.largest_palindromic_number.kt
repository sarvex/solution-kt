class Solution {
  fun largestPalindromic(num: String): String {
    val cnt = IntArray(10)
    for (c in num.toCharArray()) {
      ++cnt[c.code - '0'.code]
    }
    var mid = ""
    for (i in 9 downTo 0) {
      if (cnt[i] % 2 == 1) {
        mid += i
        --cnt[i]
        break
      }
    }
    val sb = StringBuilder()
    for (i in 0..9) {
      if (cnt[i] > 0) {
        cnt[i] = cnt[i] shr 1
        sb.append(("" + i).repeat(cnt[i]))
      }
    }
    while (sb.length > 0 && sb[sb.length - 1] == '0') {
      sb.deleteCharAt(sb.length - 1)
    }
    val t = sb.toString()
    val ans = sb.reverse().toString() + mid + t
    return if ("" == ans) "0" else ans
  }
}
