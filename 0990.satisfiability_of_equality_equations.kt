class Solution {
  private var p: IntArray
  fun equationsPossible(equations: Array<String>): Boolean {
    p = IntArray(26)
    for (i in 0..25) {
      p[i] = i
    }
    for (e in equations) {
      val a = e[0].code - 'a'.code
      val b = e[3].code - 'a'.code
      if (e[1] == '=') {
        p[find(a)] = find(b)
      }
    }
    for (e in equations) {
      val a = e[0].code - 'a'.code
      val b = e[3].code - 'a'.code
      if (e[1] == '!' && find(a) == find(b)) {
        return false
      }
    }
    return true
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
