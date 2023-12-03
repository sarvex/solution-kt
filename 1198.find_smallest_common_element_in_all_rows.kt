internal class Solution {
  fun smallestCommonElement(mat: Array<IntArray>): Int {
    val cnt = IntArray(10001)
    for (row in mat) {
      for (x in row) {
        if (++cnt[x] == mat.size) {
          return x
        }
      }
    }
    return -1
  }
}
