package academy.learnprogramming.challenge5

fun main(args: Array<String>) {

  val joe = Person("Joe", "Jones", 45)
  val jane = Person("Jane", "Smith", 12)
  val mary = Person("Mary", "Wilson", 70)
  val john = Person("John", "Adams", 32)
  val jean = Person("Jean", "Smithson", 66)

  // 1
  val (fName, lName, age) = joe
  println("fName = $fName, lName = $lName, age = $age")

  // 2
  val immutableMap = mapOf(
    joe.lastName to joe,
    jane.lastName to jane,
    mary.lastName to mary,
    john.lastName to john,
    jean.lastName to jean,
  )
  println(immutableMap)

  // 3
  println(immutableMap.count { it.value.lastName.uppercase().startsWith('S') })

  // 4
  println(immutableMap.values
    .map { Pair(it.firstName, it.lastName) }
    .toList()
  )

  // 5
  // also()
  // Joe is 45 years old
  // Jane is 12 years old
  // etc.
  immutableMap.also {
    it.map { println("${it.value.firstName} is ${it.value.age} old")}
  }

  // 6
  val list1 = listOf(1, 4, 9, 15, 33)
  val list2 = listOf(4, 55, -83, 15, 22, 101)
  val list3 = list1.filter { it in list2 }
  println(list3)

  // 7
  val regularPaper = Box<Regular>()
  var paper = Box<Paper>()
  paper = regularPaper




}

class Person(val firstName: String, val lastName: String, val age: Int) {
  operator fun component1() = firstName
  operator fun component2() = lastName
  operator fun component3() = age

}

class Box<out T> {

}

open class Paper {

}

class Regular: Paper() {

}

class Premium: Paper() {

}