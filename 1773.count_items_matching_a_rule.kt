class Solution {
  fun countMatches(items: List<List<String?>>, ruleKey: String, ruleValue: String?): Int {
    val i = if (ruleKey[0] == 't') 0 else if (ruleKey[0] == 'c') 1 else 2
    var ans = 0
    for (v in items) {
      if (v[i].equals(ruleValue)) {
        ++ans
      }
    }
    return ans
  }
}
