class Solution {
  fun longestString(x: Int, y: Int, z: Int): Int {
    if (x < y) {
      return (x * 2 + z + 1) * 2
    }
    return if (x > y) {
      (y * 2 + z + 1) * 2
    } else (x + y + z) * 2
  }
}
