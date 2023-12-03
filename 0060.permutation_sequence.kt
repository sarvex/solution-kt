internal class Solution {
  fun getPermutation(n: Int, k: Int): String {
    var k = k
    val ans = StringBuilder()
    val vis = BooleanArray(n + 1)
    for (i in 0 until n) {
      var fact = 1
      for (j in 1 until n - i) {
        fact *= j
      }
      for (j in 1..n) {
        if (!vis[j]) {
          if (k > fact) {
            k -= fact
          } else {
            ans.append(j)
            vis[j] = true
            break
          }
        }
      }
    }
    return ans.toString()
  }
}
