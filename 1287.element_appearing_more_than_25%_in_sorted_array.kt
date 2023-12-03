class Solution {
  fun findSpecialInteger(arr: IntArray): Int {
    val n = arr.size
    for (i in 0 until n) {
      if (arr[i] == arr[i + (n shr 2)]) {
        return arr[i]
      }
    }
    return 0
  }
}
