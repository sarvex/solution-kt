class AuthenticationManager(private val t: Int) {
  private val d: Map<String, Int> = HashMap()
  fun generate(tokenId: String?, currentTime: Int) {
    d.put(tokenId, currentTime + t)
  }

  fun renew(tokenId: String, currentTime: Int) {
    if (d[tokenId] ?: 0 <= currentTime) {
      return
    }
    generate(tokenId, currentTime)
  }

  fun countUnexpiredTokens(currentTime: Int): Int {
    var ans = 0
    for (exp in d.values()) {
      if (exp > currentTime) {
        ++ans
      }
    }
    return ans
  }
}
