internal class Solution {
  fun judgePoint24(nums: IntArray?): Boolean {
    return dfs(Arrays.stream(nums).boxed().map { Double() }.collect(Collectors.toList()))
  }

  private fun dfs(numList: List<Double>): Boolean {
    if (numList.size() === 0) {
      return false
    }
    if (numList.size() === 1) {
      return Math.abs(Math.abs(numList[0] - 24.0)) < 0.000001
    }
    for (i in 0 until numList.size()) {
      for (j in i + 1 until numList.size()) {
        val valid = (dfs(getList(numList, i, j, 0)) || dfs(getList(numList, i, j, 1))
            || dfs(getList(numList, i, j, 2)) || dfs(getList(numList, i, j, 3))
            || dfs(getList(numList, i, j, 4)) || dfs(getList(numList, i, j, 5)))
        if (valid) {
          return true
        }
      }
    }
    return false
  }

  private fun getList(numList: List<Double>, i: Int, j: Int, operate: Int): List<Double> {
    val candidate: List<Double> = ArrayList()
    for (k in 0 until numList.size()) {
      if (k == i || k == j) {
        continue
      }
      candidate.add(numList[k])
    }
    when (operate) {
      0 -> candidate.add(numList[i] + numList[j])
      1 -> candidate.add(numList[i] - numList[j])
      2 -> candidate.add(numList[j] - numList[i])
      3 -> candidate.add(numList[i] * numList[j])
      4 -> {
        if (numList[j] === 0) {
          return Collections.emptyList()
        }
        candidate.add(numList[i] / numList[j])
      }

      5 -> {
        if (numList[i] === 0) {
          return Collections.emptyList()
        }
        candidate.add(numList[j] / numList[i])
      }
    }
    return candidate
  }
}
