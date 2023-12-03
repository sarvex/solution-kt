internal class Solution {
  fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 0
    var j = numbers.size - 1
    while (true) {
      val x = numbers[i] + numbers[j]
      if (x == target) {
        return intArrayOf(i + 1, j + 1)
      }
      if (x < target) {
        ++i
      } else {
        --j
      }
    }
  }
}
