class Solution {
  fun pancakeSort(arr: IntArray): List<Int> {
    val n = arr.size
    val ans: List<Int> = ArrayList()
    for (i in n - 1 downTo 1) {
      var j = i
      while (j > 0 && arr[j] != i + 1) {
        --j
      }
      if (j < i) {
        if (j > 0) {
          ans.add(j + 1)
          reverse(arr, j)
        }
        ans.add(i + 1)
        reverse(arr, i)
      }
    }
    return ans
  }

  private fun reverse(arr: IntArray, j: Int) {
    var j = j
    var i = 0
    while (i < j) {
      val t = arr[i]
      arr[i] = arr[j]
      arr[j] = t
      ++i
      --j
    }
  }
}
