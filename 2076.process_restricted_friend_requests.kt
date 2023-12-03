internal class Solution {
  private var p: IntArray
  fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    val ans = BooleanArray(requests.size)
    var i = 0
    for (req in requests) {
      val u = req[0]
      val v = req[1]
      if (find(u) == find(v)) {
        ans[i++] = true
      } else {
        var valid = true
        for (res in restrictions) {
          val x = res[0]
          val y = res[1]
          if (find(u) == find(x) && find(v) == find(y) || find(u) == find(y) && find(v) == find(x)) {
            valid = false
            break
          }
        }
        if (valid) {
          p[find(u)] = find(v)
          ans[i++] = true
        } else {
          ans[i++] = false
        }
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
