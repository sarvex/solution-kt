class Solution {
  fun countTriplets(arr: IntArray): Int {
    val n = arr.size
    val pre = IntArray(n + 1)
    for (i in 0 until n) {
      pre[i + 1] = pre[i] xor arr[i]
    }
    var ans = 0
    for (i in 0 until n - 1) {
      for (j in i + 1 until n) {
        for (k in j until n) {
          val a = pre[j] xor pre[i]
          val b = pre[k + 1] xor pre[j]
          if (a == b) {
            ++ans
          }
        }
      }
    }
    return ans
  }
}
