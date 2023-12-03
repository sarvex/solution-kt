internal class Solution {
  fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
    var tx = tx
    var ty = ty
    while (tx > sx && ty > sy && tx != ty) {
      if (tx > ty) {
        tx %= ty
      } else {
        ty %= tx
      }
    }
    if (tx == sx && ty == sy) {
      return true
    }
    if (tx == sx) {
      return ty > sy && (ty - sy) % tx == 0
    }
    return if (ty == sy) {
      tx > sx && (tx - sx) % ty == 0
    } else false
  }
}
