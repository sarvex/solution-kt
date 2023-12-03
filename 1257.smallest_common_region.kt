internal class Solution {
  fun findSmallestRegion(regions: List<List<String?>>, region1: String?, region2: String?): String? {
    var region1 = region1
    var region2 = region2
    val m: Map<String?, String> = HashMap()
    for (region in regions) {
      for (i in 1 until region.size()) {
        m.put(region[i], region[0])
      }
    }
    val s: Set<String?> = HashSet()
    while (m.containsKey(region1)) {
      s.add(region1)
      region1 = m[region1]
    }
    while (m.containsKey(region2)) {
      if (s.contains(region2)) {
        return region2
      }
      region2 = m[region2]
    }
    return region1
  }
}
