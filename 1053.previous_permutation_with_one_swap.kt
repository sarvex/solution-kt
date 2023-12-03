internal class Solution {
  fun prevPermOpt1(arr: IntArray): IntArray {
    val n = arr.size
    for (i in n - 1 downTo 1) {
      if (arr[i - 1] > arr[i]) {
        for (j in n - 1 downTo i - 1 + 1) {
          if (arr[j] < arr[i - 1] && arr[j] != arr[j - 1]) {
            val t = arr[i - 1]
            arr[i - 1] = arr[j]
            arr[j] = t
            return arr
          }
        }
      }
    }
    return arr
  }
}
