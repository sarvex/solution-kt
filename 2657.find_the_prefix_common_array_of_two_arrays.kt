class Solution {
  fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    val n = A.size
    val ans = IntArray(n)
    val vis = IntArray(n + 1)
    Arrays.fill(vis, 1)
    var s = 0
    for (i in 0 until n) {
      vis[A[i]] = vis[A[i]] xor 1
      s += vis[A[i]]
      vis[B[i]] = vis[B[i]] xor 1
      s += vis[B[i]]
      ans[i] = s
    }
    return ans
  }
}
