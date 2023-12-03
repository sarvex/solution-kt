class Solution {
  fun arrayRankTransform(arr: IntArray): IntArray {
    val n = arr.size
    val t = arr.clone()
    Arrays.sort(t)
    var m = 0
    for (i in 0 until n) {
      if (i == 0 || t[i] != t[i - 1]) {
        t[m++] = t[i]
      }
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = Arrays.binarySearch(t, 0, m, arr[i]) + 1
    }
    return ans
  }
}
