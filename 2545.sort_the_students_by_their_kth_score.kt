class Solution {
  fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
    Arrays.sort(score) { a, b -> b.get(k) - a.get(k) }
    return score
  }
}
