internal class Solution {
  private var p: IntArray
  fun accountsMerge(accounts: List<List<String?>>): List<List<String>> {
    val n: Int = accounts.size()
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    val emailId: Map<String?, Int> = HashMap()
    for (i in 0 until n) {
      val account = accounts[i]
      val name = account[0]
      for (j in 1 until account.size()) {
        val email = account[j]
        if (emailId.containsKey(email)) {
          p[find(i)] = find(emailId[email]!!)
        } else {
          emailId.put(email, i)
        }
      }
    }
    val mp: Map<Int, Set<String>> = HashMap()
    for (i in 0 until n) {
      val account = accounts[i]
      for (j in 1 until account.size()) {
        val email = account[j]
        mp.computeIfAbsent(find(i)) { k -> HashSet() }.add(email)
      }
    }
    val res: List<List<String>> = ArrayList()
    for (entry in mp.entrySet()) {
      val t: List<String> = LinkedList()
      t.addAll(entry.getValue())
      Collections.sort(t)
      t.add(0, accounts[entry.getKey()][0])
      res.add(t)
    }
    return res
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
