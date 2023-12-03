internal class Solution {
  fun uniqueOccurrences(arr: IntArray): Boolean {
    val cnt: Map<Int, Int> = HashMap()
    for (x in arr) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return HashSet(cnt.values()).size() === cnt.size()
  }
}
