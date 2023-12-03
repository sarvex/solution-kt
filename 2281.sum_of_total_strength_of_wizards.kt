class Solution {
  fun totalStrength(strength: IntArray): Int {
    val n = strength.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      while (!stk.isEmpty() && strength[stk.peek()] >= strength[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && strength[stk.peek()] > strength[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val mod = 1e9.toInt() + 7
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = (s[i] + strength[i]) % mod
    }
    val ss = IntArray(n + 2)
    for (i in 0 until n + 1) {
      ss[i + 1] = (ss[i] + s[i]) % mod
    }
    var ans: Long = 0
    for (i in 0 until n) {
      val v = strength[i]
      val l = left[i] + 1
      val r = right[i] - 1
      val a = (i - l + 1).toLong() * (ss[r + 2] - ss[i + 1])
      val b = (r - i + 1).toLong() * (ss[i + 1] - ss[l])
      ans = (ans + v * ((a - b) % mod)) % mod
    }
    return (ans + mod).toInt() % mod
  }
}
