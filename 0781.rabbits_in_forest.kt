import kotlin.math.ceil

internal class Solution {
  fun numRabbits(answers: IntArray): Int {
    val counter: Map<Int, Int> = HashMap()
    for (e in answers) {
      counter.put(e, (counter[e] ?: 0) + 1)
    }
    var res = 0
    for (entry in counter.entrySet()) {
      val answer: Int = entry.getKey()
      val count: Int = entry.getValue()
      res += ceil(count / ((answer + 1) * 1.0)).toInt() * (answer + 1)
    }
    return res
  }
}
