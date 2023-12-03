class Solution {
  fun sortByBits(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0 until n) {
      arr[i] += Integer.bitCount(arr[i]) * 100000
    }
    Arrays.sort(arr)
    for (i in 0 until n) {
      arr[i] %= 100000
    }
    return arr
  }
}
