/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is lower than the guess number
 * 1 if num is higher than the guess number
 * otherwise return 0
 * int guess(int num);
 */
class Solution : GuessGame() {
  fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left < right) {
      val mid = left + right ushr 1
      if (guess(mid) <= 0) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
