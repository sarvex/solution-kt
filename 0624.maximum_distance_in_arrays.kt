import kotlin.math.max

internal class Solution {
  fun maxDistance(arrays: List<List<Int>>): Int {
    var ans = 0
    var mi = arrays[0][0]
    var mx = arrays[0][arrays[0].size() - 1]
    for (i in 1 until arrays.size()) {
      val arr: Unit = arrays[i]
      val a: Int = Math.abs(arr.get(0) - mx)
      val b: Int = Math.abs(arr.get(arr.size() - 1) - mi)
      ans = max(ans.toDouble(), max(a.toDouble(), b.toDouble())).toInt()
      mi = Math.min(mi, arr.get(0))
      mx = Math.max(mx, arr.get(arr.size() - 1))
    }
    return ans
  }
}
