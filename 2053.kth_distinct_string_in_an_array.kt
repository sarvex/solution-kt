internal class Solution {
  fun kthDistinct(arr: Array<String>, k: Int): String {
    var k = k
    val counter: Map<String, Int> = HashMap()
    for (v in arr) {
      counter.put(v, (counter[v] ?: 0) + 1)
    }
    for (v in arr) {
      if (counter[v] === 1) {
        --k
        if (k == 0) {
          return v
        }
      }
    }
    return ""
  }
}
