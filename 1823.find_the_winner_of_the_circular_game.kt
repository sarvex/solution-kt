class Solution {
  fun findTheWinner(n: Int, k: Int): Int {
    if (n == 1) {
      return 1
    }
    val ans = (findTheWinner(n - 1, k) + k) % n
    return if (ans == 0) n else ans
  }
}
