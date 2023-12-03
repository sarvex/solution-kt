class Solution {
  fun minMoves(target: Int, maxDoubles: Int): Int {
    var target = target
    var maxDoubles = maxDoubles
    var ans = 0
    while (maxDoubles > 0 && target > 1) {
      ++ans
      if (target % 2 == 1) {
        --target
      } else {
        --maxDoubles
        target = target shr 1
      }
    }
    ans += target - 1
    return ans
  }
}
