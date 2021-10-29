import projet._

class projet_test extends org.scalatest.FunSuite {
  test("giveMeHelloString function"){
    assert(giveMeHelloString == "Hello")
  }

  test("lastA function") {
    assert(projet.lastA(List(1, 1, 2, 3, 5, 8)).get == 8)
    assert(projet.lastA(Nil).isEmpty)
  }

  test("lastB function") {
    assert(projet.lastB(List(1, 1, 2, 3, 5, 8)).get == 8)
    assert(projet.lastB(Nil).isEmpty)
  }

  test("nthA function") {
    assert(projet.nthA(2, List(1, 1, 2, 3, 5, 8)).get == 2)
    assert(projet.nthA(6, List(1, 1, 2, 3, 5, 8)).isEmpty)
    assert(projet.nthA(-4, List(1, 1, 2, 3, 5, 8)).isEmpty)
    assert(projet.nthA(0, List()).isEmpty)
    assert(projet.nthA(0, Nil).isEmpty)
  }

  test("nthB function") {
    assert(projet.nthB(2, List(1, 1, 2, 3, 5, 8)).get == 2)
    assert(projet.nthB(6, List(1, 1, 2, 3, 5, 8)).isEmpty)
    assert(projet.nthB(-4, List(1, 1, 2, 3, 5, 8)).isEmpty)
    assert(projet.nthB(0, List()).isEmpty)
    assert(projet.nthB(0, Nil).isEmpty)
  }

  test("reverseA function") {
    assert(projet.reverseA(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1))
    assert(projet.reverseA(Nil) == Nil)
  }

  test("reverseB function") {
    assert(projet.reverseB(List(1, 2, 3, 4, 5)) == List(5, 4, 3, 2, 1))
    assert(projet.reverseB(Nil) == Nil)
  }

  test("salarySum function") {
    assert(salarySum(List(
      Employee("Jon",2000),
      Employee("Jane",3500),
      Employee("James",4123)
    )) == 9623.0)
    assert(salarySum(Nil) == 0)
  }

  test("addressOf function") {
    assert(addressOf(List(
      User("Jon", "5 Av. des Champs-Élysées, Paris"),
      User("James","17 Boulevard Poissonnière, Paris"),
      User("Jane", "52 Rue de Saintonge, Paris")
    )) == List(
      "5 Av. des Champs-Élysées, Paris",
      "17 Boulevard Poissonnière, Paris",
      "52 Rue de Saintonge, Paris"
    ))
    assert(addressOf(Nil) == Nil)
  }

  test("average function") {
    assert(average(Iterator(1, 2, 3, 4, 5, 6, 7, 8)).get == 4.5)
    assert(average(Iterator.empty).isEmpty)
  }

  test("monoid") {
    assert((skiRatingAverage*100).round/100.0 == 4.41)
  }

}
