class Solution {
  fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
    val m = quantity.size
    val s = IntArray(1 shl m)
    for (i in 1 until (1 shl m)) {
      for (j in 0 until m) {
        if (i shr j and 1 != 0) {
          s[i] = s[i xor (1 shl j)] + quantity[j]
          break
        }
      }
    }
    val cnt: Map<Int, Int> = HashMap(50)
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val n: Int = cnt.size()
    val arr = IntArray(n)
    var i = 0
    for (x in cnt.values()) {
      arr[i++] = x
    }
    val f = Array(n) { BooleanArray(1 shl m) }
    i = 0
    while (i < n) {
      f[i][0] = true
      ++i
    }
    i = 0
    while (i < n) {
      for (j in 1 until (1 shl m)) {
        if (i > 0 && f[i - 1][j]) {
          f[i][j] = true
          continue
        }
        var k = j
        while (k > 0) {
          val ok1 = if (i == 0) j == k else f[i - 1][j xor k]
          val ok2 = s[k] <= arr[i]
          if (ok1 && ok2) {
            f[i][j] = true
            break
          }
          k = k - 1 and j
        }
      }
      ++i
    }
    return f[n - 1][(1 shl m) - 1]
  }
}
