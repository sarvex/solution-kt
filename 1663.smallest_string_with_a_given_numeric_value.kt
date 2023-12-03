class Solution {
  fun getSmallestString(n: Int, k: Int): String {
    val ans = CharArray(n)
    Arrays.fill(ans, 'a')
    var i = n - 1
    var d = k - n
    while (d > 25) {
      ans[i--] = 'z'
      d -= 25
    }
    ans[i] = ('a'.code + d).toChar()
    return String(ans)
  }
}
