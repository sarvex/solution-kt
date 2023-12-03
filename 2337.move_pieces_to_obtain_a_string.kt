class Solution {
  fun canChange(start: String, target: String): Boolean {
    val a = f(start)
    val b = f(target)
    if (a.size() !== b.size()) {
      return false
    }
    for (i in 0 until a.size()) {
      val x = a[i]
      val y = b[i]
      if (x[0] != y[0]) {
        return false
      }
      if (x[0] == 1 && x[1] < y[1]) {
        return false
      }
      if (x[0] == 2 && x[1] > y[1]) {
        return false
      }
    }
    return true
  }

  private fun f(s: String): List<IntArray> {
    val res: List<IntArray> = ArrayList()
    for (i in 0 until s.length) {
      if (s[i] == 'L') {
        res.add(intArrayOf(1, i))
      } else if (s[i] == 'R') {
        res.add(intArrayOf(2, i))
      }
    }
    return res
  }
}
