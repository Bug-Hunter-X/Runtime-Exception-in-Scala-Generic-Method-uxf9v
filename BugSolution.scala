```scala
trait MyTypeClass[T] {
  def map(x: T, f: T => T): T
}

object MyTypeClassInstances {
  implicit val intInstance: MyTypeClass[Int] = new MyTypeClass[Int] {
    override def map(x: Int, f: Int => Int): Int = f(x)
  }

  implicit val stringInstance: MyTypeClass[String] = new MyTypeClass[String] {
    override def map(x: String, f: String => String): String = f(x)
  }

  implicit val listInstance: MyTypeClass[List[Int]] = new MyTypeClass[List[Int]]{
    override def map(x: List[Int], f: List[Int] => List[Int]): List[Int] = f(x)
  }
}

class MyClass2[T](val value: T) {
  def myMethod(f: T => T)(implicit tc: MyTypeClass[T]): T = tc.map(value, f)
}

object Main {
  def main(args: Array[String]): Unit = {
    val myObject = new MyClass2(5)
    val result = myObject.myMethod(x => x + 1)
    println(result) // Output: 6

    val myObject2 = new MyClass2("hello")
    val result2 = myObject2.myMethod(x => x.toUpperCase)
    println(result2) // Output: HELLO

    val myObject3 = new MyClass2(List(1, 2, 3))
    val result3 = myObject3.myMethod(x => x.map(_ * 2))
    println(result3) // Output: List(2, 4, 6)
  }
}
```