internal class Solution {
  fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var left = 0
    var right = letters.size
    while (left < right) {
      val mid = left + right shr 1
      if (letters[mid] > target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return letters[left % letters.size]
  }
}
