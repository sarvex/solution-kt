class FileSharing(private val chunks: Int) {
  private var cur = 0
  private val reused: TreeSet<Int>
  private val userChunks: TreeMap<Int, Set<Int>>

  init {
    reused = TreeSet()
    userChunks = TreeMap()
  }

  fun join(ownedChunks: List<Int?>?): Int {
    val userID: Int
    userID = if (reused.isEmpty()) {
      ++cur
      cur
    } else {
      reused.pollFirst()
    }
    userChunks.put(userID, HashSet(ownedChunks))
    return userID
  }

  fun leave(userID: Int) {
    reused.add(userID)
    userChunks.remove(userID)
  }

  fun request(userID: Int, chunkID: Int): List<Int> {
    if (chunkID < 1 || chunkID > chunks) {
      return Collections.emptyList()
    }
    val res: List<Int> = ArrayList()
    for (entry in userChunks.entrySet()) {
      if (entry.getValue().contains(chunkID)) {
        res.add(entry.getKey())
      }
    }
    if (!res.isEmpty()) {
      userChunks.computeIfAbsent(userID) { k -> HashSet() }.add(chunkID)
    }
    return res
  }
}
