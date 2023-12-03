class Solution {
  fun colorRed(n: Int): Array<IntArray> {
    val ans: List<IntArray> = ArrayList()
    ans.add(intArrayOf(1, 1))
    var i = n
    var k = 0
    while (i > 1) {
      if (k == 0) {
        var j = 1
        while (j < i shl 1) {
          ans.add(intArrayOf(i, j))
          j += 2
        }
      } else if (k == 1) {
        ans.add(intArrayOf(i, 2))
      } else if (k == 2) {
        var j = 3
        while (j < i shl 1) {
          ans.add(intArrayOf(i, j))
          j += 2
        }
      } else {
        ans.add(intArrayOf(i, 1))
      }
      --i
      k = (k + 1) % 4
    }
    return ans.toArray(arrayOfNulls<IntArray>(0))
  }
}
