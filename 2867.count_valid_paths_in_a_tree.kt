class Solution {
  fun countPaths(n: Int, edges: Array<IntArray>): Long {
    val prime: List<Boolean> = ArrayList(n + 1)
    for (i in 0..n) {
      prime.add(true)
    }
    prime.set(1, false)
    val all: List<Int> = ArrayList()
    for (i in 2..n) {
      if (prime[i]) {
        all.add(i)
      }
      for (x in all) {
        val temp = i * x
        if (temp > n) {
          break
        }
        prime.set(temp, false)
        if (i % x == 0) {
          break
        }
      }
    }
    val con: List<List<Int>> = ArrayList(n + 1)
    for (i in 0..n) {
      con.add(ArrayList())
    }
    for (e in edges) {
      con[e[0]].add(e[1])
      con[e[1]].add(e[0])
    }
    val r = longArrayOf(0)
    dfs(1, 0, con, prime, r)
    return r[0]
  }

  private fun mul(x: Long, y: Long): Long {
    return x * y
  }

  private inner class Pair internal constructor(var first: Int, var second: Int)

  private fun dfs(x: Int, f: Int, con: List<List<Int>>, prime: List<Boolean>, r: LongArray): Solution.Pair {
    val v: Solution.Pair = Solution.Pair(if (!prime[x]) 1 else 0, if (prime[x]) 1 else 0)
    for (y in con[x]) {
      if (y == f) continue
      val p: Solution.Pair = dfs(y, x, con, prime, r)
      r[0] += mul(p.first.toLong(), v.second.toLong()) + mul(p.second.toLong(), v.first.toLong())
      if (prime[x]) {
        v.second += p.first
      } else {
        v.first += p.first
        v.second += p.second
      }
    }
    return v
  }
}
