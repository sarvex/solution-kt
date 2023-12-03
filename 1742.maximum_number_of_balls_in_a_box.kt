class Solution {
  fun countBalls(lowLimit: Int, highLimit: Int): Int {
    val cnt = IntArray(50)
    for (i in lowLimit..highLimit) {
      var y = 0
      var x = i
      while (x > 0) {
        y += x % 10
        x /= 10
      }
      ++cnt[y]
    }
    return Arrays.stream(cnt).max().getAsInt()
  }
}
