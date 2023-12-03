internal class Solution {
  fun numUniqueEmails(emails: Array<String>): Int {
    val s: Set<String> = HashSet()
    for (email in emails) {
      val t = email.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      var local = t[0].replace(".", "")
      val domain = t[1]
      val i = local.indexOf('+')
      if (i != -1) {
        local = local.substring(0, i)
      }
      s.add("$local@$domain")
    }
    return s.size()
  }
}
