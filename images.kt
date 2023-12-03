import kotlin.math.max

class Solution {
  fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val n = plantTime.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(plantTime[i], growTime[i])
    }
    Arrays.sort(arr) { a, b -> b.get(1) - a.get(1) }
    var ans = 0
    var t = 0
    for (e in arr) {
      t += e[0]
      ans = max(ans.toDouble(), (t + e[1]).toDouble()).toInt()
    }
    return ans
  }
}
