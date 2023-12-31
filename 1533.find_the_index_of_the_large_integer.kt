/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * // Compares the sum of arr[l..r] with the sum of arr[x..y]
 * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 * public int compareSub(int l, int r, int x, int y) {}
 *
 * // Returns the length of the array
 * public int length() {}
 * }
 */
internal class Solution {
  fun getIndex(reader: ArrayReader): Int {
    var left = 0
    var right: Int = reader.length() - 1
    while (left < right) {
      val t1 = left
      val t2 = left + (right - left) / 3
      val t3 = left + (right - left) / 3 * 2 + 1
      val cmp: Int = reader.compareSub(t1, t2, t2 + 1, t3)
      if (cmp == 0) {
        left = t3 + 1
      } else if (cmp == 1) {
        right = t2
      } else {
        left = t2 + 1
        right = t3
      }
    }
    return left
  }
}
