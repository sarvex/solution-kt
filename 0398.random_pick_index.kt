internal class Solution(private val nums: IntArray) {
  private val random: Random = Random()
  fun pick(target: Int): Int {
    var n = 0
    var ans = 0
    for (i in nums.indices) {
      if (nums[i] == target) {
        ++n
        val x: Int = 1 + random.nextInt(n)
        if (x == n) {
          ans = i
        }
      }
    }
    return ans
  }
}
