class Solution {
  fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
    val ans: Set<Int> = HashSet()
    var a = 1
    while (a <= bound) {
      var b = 1
      while (a + b <= bound) {
        ans.add(a + b)
        if (y == 1) {
          break
        }
        b *= y
      }
      if (x == 1) {
        break
      }
      a *= x
    }
    return ArrayList(ans)
  }
}
