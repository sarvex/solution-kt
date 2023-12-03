internal class Solution {
  fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var n = n
    val m = flowerbed.size
    for (i in 0 until m) {
      val l = if (i == 0) 0 else flowerbed[i - 1]
      val r = if (i == m - 1) 0 else flowerbed[i + 1]
      if (l + flowerbed[i] + r == 0) {
        flowerbed[i] = 1
        --n
      }
    }
    return n <= 0
  }
}
