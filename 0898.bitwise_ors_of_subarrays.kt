internal class Solution {
  fun subarrayBitwiseORs(arr: IntArray): Int {
    val s: Set<Int> = HashSet()
    var prev = 0
    for (i in arr.indices) {
      prev = prev or arr[i]
      var curr = 0
      for (j in i downTo 0) {
        curr = curr or arr[j]
        s.add(curr)
        if (curr == prev) {
          break
        }
      }
    }
    return s.size()
  }
}
