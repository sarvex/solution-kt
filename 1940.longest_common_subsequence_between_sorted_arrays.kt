class Solution {
  fun longestCommomSubsequence(arrays: Array<IntArray>): List<Int> {
    val counter: Map<Int, Int> = HashMap()
    for (array in arrays) {
      for (e in array) {
        counter.put(e, (counter[e] ?: 0) + 1)
      }
    }
    val n = arrays.size
    val res: List<Int> = ArrayList()
    for (entry in counter.entrySet()) {
      if (entry.getValue() === n) {
        res.add(entry.getKey())
      }
    }
    return res
  }
}
