package newts

import cats.kernel.laws.{GroupLaws, OrderLaws}

class MaxTest extends NewtsSuite {

  checkAll("Max[Int]", GroupLaws[Max[Int]].semigroup)
  checkAll("Max[Int]", GroupLaws[Max[Int]].monoid)
  checkAll("Max[Int]", OrderLaws[Max[Int]].order)

  test("combine"){
    5.asMax |+| 1.asMax shouldEqual Max(5)
    1.asMax |+| 5.asMax shouldEqual Max(5)
  }

  test("show") {
    Max(5).show   shouldEqual "Max(5)"
    Max("1").show shouldEqual "Max(1)"
  }
}
