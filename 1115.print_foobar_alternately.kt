class FooBar(private val n: Int) {
  private val f: Semaphore = Semaphore(1)
  private val b: Semaphore = Semaphore(0)
  @Throws(InterruptedException::class)
  fun foo(printFoo: Runnable) {
    for (i in 0 until n) {
      f.acquire(1)
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run()
      b.release(1)
    }
  }

  @Throws(InterruptedException::class)
  fun bar(printBar: Runnable) {
    for (i in 0 until n) {
      b.acquire(1)
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run()
      f.release(1)
    }
  }
}
