/**
 * Definition for BigArray.
 * class BigArray {
 * public BigArray(int[] elements);
 * public int at(long index);
 * public long size();
 * }
 */
internal class Solution {
  fun countBlocks(nums: BigArray): Int {
    var ans = 0
    var i: Long = 0
    val n: Long = nums.size()
    while (i < n) {
      i = search(nums, i, n)
      ++ans
    }
    return ans
  }

  private fun search(nums: BigArray, l: Long, n: Long): Long {
    var l = l
    var r = n
    val x: Int = nums.at(l)
    while (l < r) {
      val mid = l + r shr 1
      if (nums.at(mid) !== x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
