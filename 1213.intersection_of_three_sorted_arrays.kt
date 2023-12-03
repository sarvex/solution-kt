internal class Solution {
  fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
    val ans: List<Int> = ArrayList()
    val cnt = IntArray(2001)
    for (x in arr1) {
      ++cnt[x]
    }
    for (x in arr2) {
      ++cnt[x]
    }
    for (x in arr3) {
      if (++cnt[x] == 3) {
        ans.add(x)
      }
    }
    return ans
  }
}
