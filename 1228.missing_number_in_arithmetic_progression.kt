internal class Solution {
  fun missingNumber(arr: IntArray): Int {
    val n = arr.size
    val x = (arr[0] + arr[n - 1]) * (n + 1) / 2
    val y: Int = Arrays.stream(arr).sum()
    return x - y
  }
}
