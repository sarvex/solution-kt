class Solution {
  fun doesValidArrayExist(derived: IntArray): Boolean {
    var s = 0
    for (x in derived) {
      s = s xor x
    }
    return s == 0
  }
}
