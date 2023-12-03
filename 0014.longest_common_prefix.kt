internal class Solution {
  fun longestCommonPrefix(strs: Array<String>): String {
    val n = strs.size
    for (i in 0 until strs[0].length) {
      for (j in 1 until n) {
        if (strs[j].length <= i || strs[j][i] != strs[0][i]) {
          return strs[0].substring(0, i)
        }
      }
    }
    return strs[0]
  }
}
