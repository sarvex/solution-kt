class ThroneInheritance(private val king: String) {
  private val g: Map<String, List<String>> = HashMap()
  private val dead: Set<String> = HashSet()
  private var ans: List<String>? = null
  fun birth(parentName: String?, childName: String?) {
    g.computeIfAbsent(parentName) { k -> ArrayList() }.add(childName)
  }

  fun death(name: String?) {
    dead.add(name)
  }

  val inheritanceOrder: List<String>
    get() {
      ans = ArrayList()
      dfs(king)
      return ans
    }

  private fun dfs(x: String) {
    if (!dead.contains(x)) {
      ans.add(x)
    }
    for (y in g[x] ?: Collections.emptyList()) {
      dfs(y)
    }
  }
}
