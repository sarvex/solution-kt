internal class Solution {
  fun divideString(s: String, k: Int, fill: Char): Array<String?> {
    var s = s
    val n = s.length
    val ans = arrayOfNulls<String>((n + k - 1) / k)
    if (n % k != 0) {
      s += fill.toString().repeat(k - n % k)
    }
    for (i in ans.indices) {
      ans[i] = s.substring(i * k, (i + 1) * k)
    }
    return ans
  }
}
