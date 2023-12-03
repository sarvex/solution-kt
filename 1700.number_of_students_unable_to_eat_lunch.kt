class Solution {
  fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val cnt = IntArray(2)
    for (v in students) {
      ++cnt[v]
    }
    for (v in sandwiches) {
      if (cnt[v]-- == 0) {
        return cnt[v xor 1]
      }
    }
    return 0
  }
}
