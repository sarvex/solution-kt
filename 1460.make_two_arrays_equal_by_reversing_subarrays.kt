class Solution {
  fun canBeEqual(target: IntArray?, arr: IntArray?): Boolean {
    Arrays.sort(target)
    Arrays.sort(arr)
    return Arrays.equals(target, arr)
  }
}
