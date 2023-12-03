internal class Solution {
  fun removeSubfolders(folder: Array<String>): List<String> {
    Arrays.sort(folder)
    val ans: List<String> = ArrayList()
    ans.add(folder[0])
    for (i in 1 until folder.size) {
      val m: Int = ans[ans.size() - 1].length()
      val n = folder[i].length
      if (m >= n
        || !(ans[ans.size() - 1].equals(folder[i].substring(0, m))
            && folder[i][m] == '/')
      ) {
        ans.add(folder[i])
      }
    }
    return ans
  }
}
