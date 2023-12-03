class Solution {
  fun checkIfExist(arr: IntArray): Boolean {
    val m: Map<Int, Int> = HashMap()
    val n = arr.size
    for (i in 0 until n) {
      m.put(arr[i], i)
    }
    for (i in 0 until n) {
      if (m.containsKey(arr[i] shl 1) && m[arr[i] shl 1] !== i) {
        return true
      }
    }
    return false
  }
}
