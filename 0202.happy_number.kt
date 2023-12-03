internal class Solution {
  fun isHappy(n: Int): Boolean {
    var slow = n
    var fast = next(n)
    while (slow != fast) {
      slow = next(slow)
      fast = next(next(fast))
    }
    return slow == 1
  }

  private fun next(x: Int): Int {
    var x = x
    var y = 0
    while (x > 0) {
      y += x % 10 * (x % 10)
      x /= 10
    }
    return y
  }
}
