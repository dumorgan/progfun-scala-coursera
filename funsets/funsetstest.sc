
object FunSets {
  /**
    * We represent a set by its characteristic function, i.e.
    * its `contains` predicate.
    */
  type Set = Int => Boolean

  /**
    * Indicates whether a set contains a given element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  def singletonSet(elem: Int): Set = Set(elem)

  def union(s: Set, t: Set): Set = (e: Int) => s(e) || t(e)

  def intersect(s: Set, t: Set): Set = (e: Int) => s(e) && t(e)

  def filter(s: Set, p: Int => Boolean): Set = (e: Int) => s(e) && p(e)


  val a = singletonSet(1)

  val b = singletonSet(2)

  val c = union(a,b)

  val d = filter(c, (e => if (e == 1) true else false))

  val bound = 1000
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }

  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, (x => !p(x)))

  def map(s: Set, f: Int => Int): Set = (e: Int) => exists(s, x => (f(x) == e))

  val u = union(c, singletonSet(3))

  val m = map(u, (x => 2*x))

  contains(u, 1)
  contains(u, 2)
  contains(u, 3)


  contains(m, 1)
  contains(m, 2)
  contains(m, 3)
  contains(m, 4)
  contains(m, 5)
  contains(m, 6)
}

