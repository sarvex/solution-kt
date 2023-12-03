class SQL(names: List<String?>, columns: List<Int?>?) {
  private val tables: Map<String, List<List<String>>>

  init {
    tables = HashMap(names.size())
  }

  fun insertRow(name: String?, row: List<String?>?) {
    tables.computeIfAbsent(name) { k -> ArrayList() }.add(row)
  }

  fun deleteRow(name: String?, rowId: Int) {}
  fun selectCell(name: String, rowId: Int, columnId: Int): String {
    return tables[name]!![rowId - 1][columnId - 1]
  }
}
