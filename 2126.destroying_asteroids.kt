class Solution {
  fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
    Arrays.sort(asteroids)
    var m = mass.toLong()
    for (v in asteroids) {
      if (m < v) {
        return false
      }
      m += v.toLong()
    }
    return true
  }
}
