/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
internal class Solution {
  private var mountainArr: MountainArray? = null
  private var target = 0
  fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
    val n: Int = mountainArr.length()
    var l = 0
    var r = n - 1
    while (l < r) {
      val mid = l + r ushr 1
      if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    this.mountainArr = mountainArr
    this.target = target
    val ans = search(0, l, 1)
    return if (ans == -1) search(l + 1, n - 1, -1) else ans
  }

  private fun search(l: Int, r: Int, k: Int): Int {
    var l = l
    var r = r
    while (l < r) {
      val mid = l + r ushr 1
      if (k * mountainArr.get(mid) >= k * target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return if (mountainArr.get(l) === target) l else -1
  }
}
