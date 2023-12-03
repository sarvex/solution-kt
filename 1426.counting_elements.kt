class Solution {
  fun countElements(arr: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in arr) {
      s.add(x)
    }
    var ans = 0
    for (x in arr) {
      if (s.contains(x + 1)) {
        ++ans
      }
    }
    return ans
  }
}
