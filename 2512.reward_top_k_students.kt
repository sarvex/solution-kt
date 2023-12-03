class Solution {
  fun topStudents(
    positive_feedback: Array<String?>, negative_feedback: Array<String?>,
    report: Array<String>, student_id: IntArray, k: Int
  ): List<Int> {
    val ps: Set<String> = HashSet()
    val ns: Set<String> = HashSet()
    for (s in positive_feedback) {
      ps.add(s)
    }
    for (s in negative_feedback) {
      ns.add(s)
    }
    val n = report.size
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      val sid = student_id[i]
      var t = 0
      for (s in report[i].split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
        if (ps.contains(s)) {
          t += 3
        } else if (ns.contains(s)) {
          t -= 1
        }
      }
      arr[i] = intArrayOf(t, sid)
    }
    Arrays.sort(arr) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else b.get(0) - a.get(0) }
    val ans: List<Int> = ArrayList()
    for (i in 0 until k) {
      ans.add(arr[i][1])
    }
    return ans
  }
}
