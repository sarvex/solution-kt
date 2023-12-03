class Solution {
  fun putMarbles(weights: IntArray, k: Int): Long {
    val n = weights.size
    val arr = IntArray(n - 1)
    for (i in 0 until n - 1) {
      arr[i] = weights[i] + weights[i + 1]
    }
    Arrays.sort(arr)
    var ans: Long = 0
    for (i in 0 until k - 1) {
      ans -= arr[i].toLong()
      ans += arr[n - 2 - i].toLong()
    }
    return ans
  }
}
