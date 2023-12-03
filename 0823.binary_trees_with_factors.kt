internal class Solution {
  fun numFactoredBinaryTrees(arr: IntArray): Int {
    val mod = 1e9.toInt() + 7
    Arrays.sort(arr)
    val n = arr.size
    val f = LongArray(n)
    Arrays.fill(f, 1)
    val idx: Map<Int, Int> = HashMap(n)
    for (i in 0 until n) {
      idx.put(arr[i], i)
    }
    for (i in 0 until n) {
      val a = arr[i]
      for (j in 0 until i) {
        val b = arr[j]
        if (a % b == 0) {
          val c = a / b
          if (idx.containsKey(c)) {
            val k = idx[c]!!
            f[i] = (f[i] + f[j] * f[k]) % mod
          }
        }
      }
    }
    var ans: Long = 0
    for (v in f) {
      ans = (ans + v) % mod
    }
    return ans.toInt()
  }
}
