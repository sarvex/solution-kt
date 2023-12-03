internal class Solution {
  fun transformArray(arr: IntArray): List<Int> {
    var f = true
    while (f) {
      f = false
      val t = arr.clone()
      for (i in 1 until t.size - 1) {
        if (t[i] > t[i - 1] && t[i] > t[i + 1]) {
          --arr[i]
          f = true
        }
        if (t[i] < t[i - 1] && t[i] < t[i + 1]) {
          ++arr[i]
          f = true
        }
      }
    }
    val ans: List<Int> = ArrayList()
    for (x in arr) {
      ans.add(x)
    }
    return ans
  }
}
