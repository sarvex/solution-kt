class Solution {
  private val mod = 1e9.toInt() + 7
  fun maximumScore(nums: List<Int>, k: Int): Int {
    var k = k
    val n: Int = nums.size()
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(i, primeFactors(nums[i]), nums[i])
    }
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (e in arr) {
      val i = e[0]
      val f = e[1]
      while (!stk.isEmpty() && arr[stk.peek()][1] < f) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      val f = arr[i][1]
      while (!stk.isEmpty() && arr[stk.peek()][1] <= f) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    Arrays.sort(arr) { a, b -> b.get(2) - a.get(2) }
    var ans: Long = 1
    for (e in arr) {
      val i = e[0]
      val x = e[2]
      val l = left[i]
      val r = right[i]
      val cnt = (i - l).toLong() * (r - i)
      if (cnt <= k) {
        ans = ans * qpow(x.toLong(), cnt) % mod
        k -= cnt.toInt()
      } else {
        ans = ans * qpow(x.toLong(), k.toLong()) % mod
        break
      }
    }
    return ans.toInt()
  }

  private fun primeFactors(n: Int): Int {
    var n = n
    var i = 2
    val ans: Set<Int> = HashSet()
    while (i <= n / i) {
      while (n % i == 0) {
        ans.add(i)
        n /= i
      }
      ++i
    }
    if (n > 1) {
      ans.add(n)
    }
    return ans.size()
  }

  private fun qpow(a: Long, n: Long): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1L == 1L) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
