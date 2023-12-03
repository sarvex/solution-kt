class Solution {
  fun destCity(paths: List<List<String?>>): String {
    val s: Set<String> = HashSet()
    for (p in paths) {
      s.add(p[0])
    }
    for (p in paths) {
      if (!s.contains(p[1])) {
        return p[1]
      }
    }
    return ""
  }
}
