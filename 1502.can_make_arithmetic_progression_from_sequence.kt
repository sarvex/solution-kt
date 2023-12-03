class Solution {
  fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    Arrays.sort(arr)
    val d = arr[1] - arr[0]
    for (i in 2 until arr.size) {
      if (arr[i] - arr[i - 1] != d) {
        return false
      }
    }
    return true
  }
}
