class Solution {
  fun closestPrimes(left: Int, right: Int): IntArray {
    var cnt = 0
    val st = BooleanArray(right + 1)
    val prime = IntArray(right + 1)
    for (i in 2..right) {
      if (!st[i]) {
        prime[cnt++] = i
      }
      var j = 0
      while (prime[j] <= right / i) {
        st[prime[j] * i] = true
        if (i % prime[j] == 0) {
          break
        }
        ++j
      }
    }
    var i = -1
    var j = -1
    for (k in 0 until cnt) {
      if (prime[k] >= left && prime[k] <= right) {
        if (i == -1) {
          i = k
        }
        j = k
      }
    }
    val ans = intArrayOf(-1, -1)
    if (i == j || i == -1) {
      return ans
    }
    var mi = 1 shl 30
    for (k in i until j) {
      val d = prime[k + 1] - prime[k]
      if (d < mi) {
        mi = d
        ans[0] = prime[k]
        ans[1] = prime[k + 1]
      }
    }
    return ans
  }
}
