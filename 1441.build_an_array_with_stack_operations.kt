class Solution {
  fun buildArray(target: IntArray, n: Int): List<String> {
    var cur = 0
    val ans: List<String> = ArrayList()
    for (v in target) {
      while (++cur < v) {
        ans.add("Push")
        ans.add("Pop")
      }
      ans.add("Push")
    }
    return ans
  }
}
