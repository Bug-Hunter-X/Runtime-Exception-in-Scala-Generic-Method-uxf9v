# Scala Generic Method Runtime Error

This repository demonstrates a potential runtime error in Scala when using higher-order functions with generic types.  The `myMethod` function in `Bug.scala` accepts a function `f: T => T` as an argument. While the code compiles without errors for different types like `Int` and `String`, it fails at runtime when the input type is `List[Int]`, because `List[Int]`'s `map` method returns `List[Int]`, not `List[List[Int]]` as implied by the method signature.

The `BugSolution.scala` file provides a solution using type classes to improve type safety and avoid the runtime error.