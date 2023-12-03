internal class Solution {
  fun sumSubarrayMins(arr: IntArray): Int {
    val n = arr.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val mod = 1e9.toInt() + 7
    var ans: Long = 0
    for (i in 0 until n) {
      ans += (i - left[i]).toLong() * (right[i] - i) % mod * arr[i] % mod
      ans %= mod.toLong()
    }
    return ans.toInt()
  }
}
