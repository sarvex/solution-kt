internal class Solution(private var nums: IntArray) {
  private val original: IntArray
  private val rand: Random

  init {
    original = Arrays.copyOf(nums, nums.size)
    rand = Random()
  }

  fun reset(): IntArray {
    nums = Arrays.copyOf(original, original.size)
    return nums
  }

  fun shuffle(): IntArray {
    for (i in nums.indices) {
      swap(i, i + rand.nextInt(nums.size - i))
    }
    return nums
  }

  private fun swap(i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
