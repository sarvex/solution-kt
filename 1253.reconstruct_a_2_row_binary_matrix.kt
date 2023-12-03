internal class Solution {
  fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {
    var upper = upper
    var lower = lower
    val n = colsum.size
    val first: List<Int> = ArrayList()
    val second: List<Int> = ArrayList()
    for (j in 0 until n) {
      var a = 0
      var b = 0
      if (colsum[j] == 2) {
        b = 1
        a = b
        upper--
        lower--
      } else if (colsum[j] == 1) {
        if (upper > lower) {
          upper--
          a = 1
        } else {
          lower--
          b = 1
        }
      }
      if (upper < 0 || lower < 0) {
        break
      }
      first.add(a)
      second.add(b)
    }
    return if (upper == 0 && lower == 0) List.of(first, second) else List.of()
  }
}
