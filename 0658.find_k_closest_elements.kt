internal class Solution {
  fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var left = 0
    var right = arr.size - k
    while (left < right) {
      val mid = left + right shr 1
      if (x - arr[mid] <= arr[mid + k] - x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in left until left + k) {
      ans.add(arr[i])
    }
    return ans
  }
}
