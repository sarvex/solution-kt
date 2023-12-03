class Solution {
  fun isWinner(player1: IntArray, player2: IntArray): Int {
    val a = f(player1)
    val b = f(player2)
    return if (a > b) 1 else if (b > a) 2 else 0
  }

  private fun f(arr: IntArray): Int {
    var s = 0
    for (i in arr.indices) {
      val k = if (i > 0 && arr[i - 1] == 10 || i > 1 && arr[i - 2] == 10) 2 else 1
      s += k * arr[i]
    }
    return s
  }
}
