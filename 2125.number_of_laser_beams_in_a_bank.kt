class Solution {
  fun numberOfBeams(bank: Array<String>): Int {
    var last = 0
    var ans = 0
    for (b in bank) {
      var t = 0
      for (c in b.toCharArray()) {
        if (c == '1') {
          ++t
        }
      }
      if (t > 0) {
        ans += last * t
        last = t
      }
    }
    return ans
  }
}
