internal class Solution {
  fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
    val k = 4 * cheeseSlices - tomatoSlices
    val y = k / 2
    val x = cheeseSlices - y
    return if (k % 2 != 0 || y < 0 || x < 0) Collections.emptyList() else Arrays.asList(x, y)
  }
}
