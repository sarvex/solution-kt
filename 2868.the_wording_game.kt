class Solution {
  fun canAliceWin(a: Array<String>, b: Array<String>): Boolean {
    var i = 1
    var j = 0
    var k = true
    var w = a[0]
    while (true) {
      if (k) {
        if (j == b.size) {
          return true
        }
        if (b[j][0] == w[0] && w.compareTo(b[j]) < 0
          || b[j][0].code - w[0].code == 1
        ) {
          w = b[j]
          k = !k
        }
        ++j
      } else {
        if (i == a.size) {
          return false
        }
        if (a[i][0] == w[0] && w.compareTo(a[i]) < 0
          || a[i][0].code - w[0].code == 1
        ) {
          w = a[i]
          k = !k
        }
        ++i
      }
    }
  }
}
