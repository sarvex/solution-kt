class Solution {
  fun checkPalindromeFormation(a: String, b: String): Boolean {
    return check1(a, b) || check1(b, a)
  }

  private fun check1(a: String, b: String): Boolean {
    var i = 0
    var j = b.length - 1
    while (i < j && a[i] == b[j]) {
      i++
      j--
    }
    return i >= j || check2(a, i, j) || check2(b, i, j)
  }

  private fun check2(a: String, i: Int, j: Int): Boolean {
    var i = i
    var j = j
    while (i < j && a[i] == a[j]) {
      i++
      j--
    }
    return i >= j
  }
}
