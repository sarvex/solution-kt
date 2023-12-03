class LUPrefix(n: Int) {
  private var r = 0
  private val s: Set<Int> = HashSet()
  fun upload(video: Int) {
    s.add(video)
    while (s.contains(r + 1)) {
      ++r
    }
  }

  fun longest(): Int {
    return r
  }
}
