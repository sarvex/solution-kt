internal class Solution {
  fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val d: Map<String, List<String>> = HashMap()
    for (s in strs) {
      val t = s.toCharArray()
      Arrays.sort(t)
      val k = String(t)
      d.computeIfAbsent(k) { key -> ArrayList() }.add(s)
    }
    return ArrayList(d.values())
  }
}
