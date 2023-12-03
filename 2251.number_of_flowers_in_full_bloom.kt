class Solution {
  fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
    val n = flowers.size
    val start = IntArray(n)
    val end = IntArray(n)
    for (i in 0 until n) {
      start[i] = flowers[i][0]
      end[i] = flowers[i][1]
    }
    Arrays.sort(start)
    Arrays.sort(end)
    val m = people.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      ans[i] = search(start, people[i] + 1) - search(end, people[i])
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
