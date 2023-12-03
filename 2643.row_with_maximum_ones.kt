class Solution {
  fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
    val ans = IntArray(2)
    for (i in mat.indices) {
      var cnt = 0
      for (x in mat[i]) {
        if (x == 1) {
          ++cnt
        }
      }
      if (ans[1] < cnt) {
        ans[0] = i
        ans[1] = cnt
      }
    }
    return ans
  }
}
