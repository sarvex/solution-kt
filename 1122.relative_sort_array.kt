internal class Solution {
  fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val pos: Map<Int, Int> = HashMap(arr2.size)
    for (i in arr2.indices) {
      pos.put(arr2[i], i)
    }
    val arr = Array(arr1.size) { IntArray(0) }
    for (i in arr.indices) {
      arr[i] = intArrayOf(arr1[i], pos[arr1[i]] ?: arr2.size + arr1[i])
    }
    Arrays.sort(arr) { a, b -> a.get(1) - b.get(1) }
    for (i in arr.indices) {
      arr1[i] = arr[i][0]
    }
    return arr1
  }
}
