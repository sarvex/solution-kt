class Solution {
  fun kthLargestNumber(nums: Array<String?>, k: Int): String? {
    Arrays.sort(
      nums
    ) { a, b -> if (a.length() === b.length()) b.compareTo(a) else b.length() - a.length() }
    return nums[k - 1]
  }
}
