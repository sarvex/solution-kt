class Solution {
  fun countCollisions(directions: String): Int {
    val ds = directions.toCharArray()
    val n = ds.size
    var l = 0
    var r = n - 1
    while (l < n && ds[l] == 'L') {
      ++l
    }
    while (r >= 0 && ds[r] == 'R') {
      --r
    }
    var ans = 0
    for (i in l..r) {
      if (ds[i] != 'S') {
        ++ans
      }
    }
    return ans
  }
}
