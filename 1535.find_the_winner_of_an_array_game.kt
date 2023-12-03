class Solution {
  fun getWinner(arr: IntArray, k: Int): Int {
    var mx = arr[0]
    var i = 1
    var cnt = 0
    while (i < arr.size) {
      if (mx < arr[i]) {
        mx = arr[i]
        cnt = 1
      } else {
        ++cnt
      }
      if (cnt == k) {
        break
      }
      ++i
    }
    return mx
  }
}
