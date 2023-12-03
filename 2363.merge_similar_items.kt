class Solution {
  fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val cnt = IntArray(1010)
    for (x in items1) {
      cnt[x[0]] += x[1]
    }
    for (x in items2) {
      cnt[x[0]] += x[1]
    }
    val ans: List<List<Int>> = ArrayList()
    for (i in cnt.indices) {
      if (cnt[i] > 0) {
        ans.add(List.of(i, cnt[i]))
      }
    }
    return ans
  }
}
