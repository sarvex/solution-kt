class Solution {
  fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val d: Map<Int, IntArray> = HashMap()
    for (p in pieces) {
      d.put(p[0], p)
    }
    var i = 0
    while (i < arr.size) {
      if (!d.containsKey(arr[i])) {
        return false
      }
      for (v in d[arr[i]]!!) {
        if (arr[i++] != v) {
          return false
        }
      }
    }
    return true
  }
}
