import java.util.*
import kotlin.collections.ArrayList

internal class Solution {
  fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val n = nums.size
    val ans: List<List<Int>> = ArrayList()
    if (n < 4) {
      return ans
    }
    Arrays.sort(nums)
    for (i in 0 until n - 3) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue
      }
      for (j in i + 1 until n - 2) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue
        }
        var k = j + 1
        var l = n - 1
        while (k < l) {
          val x = nums[i].toLong() + nums[j] + nums[k] + nums[l]
          if (x < target) {
            ++k
          } else if (x > target) {
            --l
          } else {
            ans.add(List.of(nums[i], nums[j], nums[k++], nums[l--]))
            while (k < l && nums[k] == nums[k - 1]) {
              ++k
            }
            while (k < l && nums[l] == nums[l + 1]) {
              --l
            }
          }
        }
      }
    }
    return ans
  }
}
