class Solution {
  fun haveConflict(event1: Array<String>, event2: Array<String?>): Boolean {
    return !(event1[0].compareTo(event2[1]!!) > 0 || event1[1].compareTo(event2[0]!!) < 0)
  }
}
