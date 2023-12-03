internal class Solution {
  fun findSolution(customfunction: CustomFunction, z: Int): List<List<Int>> {
    val ans: List<List<Int>> = ArrayList()
    var x = 1
    var y = 1000
    while (x <= 1000 && y > 0) {
      val t: Int = customfunction.f(x, y)
      if (t < z) {
        x++
      } else if (t > z) {
        y--
      } else {
        ans.add(Arrays.asList(x++, y--))
      }
    }
    return ans
  }
}
