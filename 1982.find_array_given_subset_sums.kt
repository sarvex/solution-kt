import kotlin.math.min

class Solution {
  fun recoverArray(n: Int, sums: IntArray): IntArray {
    var m = 1 shl 30
    for (x in sums) {
      m = min(m.toDouble(), x.toDouble()).toInt()
    }
    m = -m
    val tm: TreeMap<Int, Int> = TreeMap()
    for (x in sums) {
      tm.merge(x + m, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans = IntArray(n)
    if (tm.merge(0, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
      tm.remove(0)
    }
    ans[0] = tm.firstKey()
    for (i in 1 until n) {
      for (j in 0 until (1 shl i)) {
        if (j shr i - 1 and 1 == 1) {
          var s = 0
          for (k in 0 until i) {
            if (j shr k and 1 == 1) {
              s += ans[k]
            }
          }
          if (tm.merge(s, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
            tm.remove(s)
          }
        }
      }
      ans[i] = tm.firstKey()
    }
    for (i in 0 until (1 shl n)) {
      var s = 0
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          s += ans[j]
        }
      }
      if (s == m) {
        for (j in 0 until n) {
          if (i shr j and 1 == 1) {
            ans[j] *= -1
          }
        }
        break
      }
    }
    return ans
  }
}
