class Solution {
  fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    val n = arr.size
    val s = IntArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] xor arr[i - 1]
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val l = queries[i][0]
      val r = queries[i][1]
      ans[i] = s[r + 1] xor s[l]
    }
    return ans
  }
}
