/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
</String> */
internal class Solution {
  private var ans: Set<String>? = null
  fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
    ans = HashSet()
    dfs(startUrl, htmlParser)
    return ArrayList(ans)
  }

  private fun dfs(url: String, htmlParser: HtmlParser) {
    if (ans!!.contains(url)) {
      return
    }
    ans.add(url)
    for (next in htmlParser.getUrls(url)) {
      if (host(next) == host(url)) {
        dfs(next, htmlParser)
      }
    }
  }

  private fun host(url: String): String {
    var url = url
    url = url.substring(7)
    return url.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
  }
}
