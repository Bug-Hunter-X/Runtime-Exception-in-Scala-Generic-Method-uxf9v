```scala
class MyClass[T](val value: T) {
  def myMethod(f: T => T): T = f(value)
}

object Main {
  def main(args: Array[String]): Unit = {
    val myObject = new MyClass(5)
    val result = myObject.myMethod(x => x + 1) // This will compile and run correctly.
    println(result) // Output: 6

    val myObject2 = new MyClass("hello")
    val result2 = myObject2.myMethod(x => x.toUpperCase) // This will also compile and run correctly
    println(result2) // Output: HELLO

    val myObject3 = new MyClass(List(1,2,3))
    val result3 = myObject3.myMethod(x=> x.map(_ * 2)) // This will cause runtime exception if not handled
    println(result3) //This line will not run
  }
}
```