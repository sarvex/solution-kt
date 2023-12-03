class Codec {
  private val m: Map<String, String> = HashMap()
  private val idx = 0
  private val domain = "https://tinyurl.com/"

  // Encodes a URL to a shortened URL.
  fun encode(longUrl: String?): String {
    val v: String = ++idx.toString()
    m.put(v, longUrl)
    return domain + v
  }

  // Decodes a shortened URL to its original URL.
  fun decode(shortUrl: String): String? {
    val i = shortUrl.lastIndexOf('/') + 1
    return m[shortUrl.substring(i)]
  }
}
