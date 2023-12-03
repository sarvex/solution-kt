class Solution {
  fun sequentialDigits(low: Int, high: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in 1..8) {
      var x = i
      for (j in i + 1..9) {
        x = x * 10 + j
        if (x >= low && x <= high) {
          ans.add(x)
        }
      }
    }
    Collections.sort(ans)
    return ans
  }
}
