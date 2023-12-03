internal class Solution {
  fun combinationSum4(nums: IntArray, target: Int): Int {
    val f = IntArray(target + 1)
    f[0] = 1
    for (i in 1..target) {
      for (x in nums) {
        if (i >= x) {
          f[i] += f[i - x]
        }
      }
    }
    return f[target]
  }
}
