internal class Solution {
  private val map: Map<Int, Employee> = HashMap()
  fun getImportance(employees: List<Employee?>, id: Int): Int {
    for (employee in employees) {
      map.put(employee.id, employee)
    }
    return dfs(id)
  }

  private fun dfs(id: Int): Int {
    val employee: Employee? = map[id]
    var sum: Int = employee.importance
    for (subordinate in employee.subordinates) {
      sum += dfs(subordinate)
    }
    return sum
  }
}
