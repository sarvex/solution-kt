class Foo {
  private val a: Semaphore = Semaphore(1)
  private val b: Semaphore = Semaphore(0)
  private val c: Semaphore = Semaphore(0)
  @Throws(InterruptedException::class)
  fun first(printFirst: Runnable) {
    a.acquire(1)
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run()
    b.release(1)
  }

  @Throws(InterruptedException::class)
  fun second(printSecond: Runnable) {
    b.acquire(1)
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run()
    c.release(1)
  }

  @Throws(InterruptedException::class)
  fun third(printThird: Runnable) {
    c.acquire(1)
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run()
    a.release(1)
  }
}
