class Solution {
  fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
    var a = 0
    var b = 0
    for (v in arr1) {
      a = a xor v
    }
    for (v in arr2) {
      b = b xor v
    }
    return a and b
  }
}
