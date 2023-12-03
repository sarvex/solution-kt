class Solution {
  fun minDeletionSize(A: Array<String>?): Int {
    if (A == null || A.size <= 1) {
      return 0
    }
    val len = A.size
    val wordLen = A[0].length
    var res = 0
    val cut = BooleanArray(len)
    search@ for (j in 0 until wordLen) {
      // 判断第 j 列是否应当保留
      for (i in 0 until len - 1) {
        if (!cut[i] && A[i][j] > A[i + 1][j]) {
          res += 1
          continue@search
        }
      }
      // 更新 cut 的信息
      for (i in 0 until len - 1) {
        if (A[i][j] < A[i + 1][j]) {
          cut[i] = true
        }
      }
    }
    return res
  }
}
