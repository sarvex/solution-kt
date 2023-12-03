internal class Solution {
  fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
    val m = s.length
    val ans = IntArray(m)
    val mp: Map<Char, IntArray> = HashMap(4)
    mp.put('L', intArrayOf(0, -1))
    mp.put('R', intArrayOf(0, 1))
    mp.put('U', intArrayOf(-1, 0))
    mp.put('D', intArrayOf(1, 0))
    for (i in 0 until m) {
      var x = startPos[0]
      var y = startPos[1]
      var t = 0
      for (j in i until m) {
        val c = s[j]
        val a = mp[c]!![0]
        val b = mp[c]!![1]
        if (0 <= x + a && x + a < n && 0 <= y + b && y + b < n) {
          x += a
          y += b
          ++t
        } else {
          break
        }
      }
      ans[i] = t
    }
    return ans
  }
}
