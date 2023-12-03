class Solution {
  fun maxDiff(num: Int): Int {
    var a = num.toString()
    var b = a
    for (i in 0 until a.length) {
      if (a[i] != '9') {
        a = a.replace(a[i], '9')
        break
      }
    }
    if (b[0] != '1') {
      b = b.replace(b[0], '1')
    } else {
      for (i in 1 until b.length) {
        if (b[i] != '0' && b[i] != '1') {
          b = b.replace(b[i], '0')
          break
        }
      }
    }
    return a.toInt() - b.toInt()
  }
}
