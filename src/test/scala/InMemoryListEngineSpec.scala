import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class InMemoryListEngineSpec extends AnyFlatSpec with Matchers {

  "A InMemoryListEngine" should "contain requests" in {
    InMemoryListEngine.clear

    InMemoryListEngine.setRequest(Item("One"), 1)
    InMemoryListEngine.setRequest(Item("Two"), 2)
    InMemoryListEngine.setRequest(Item("Three"), 3)

    assert(InMemoryListEngine.requests()(Item("One")) == 1)
    assert(InMemoryListEngine.requests()(Item("Two")) == 2)
    assert(InMemoryListEngine.requests()(Item("Three")) == 3)
  }

  it should "contain items" in {
    InMemoryListEngine.clear

    InMemoryListEngine.setRequest(Item("One"), 1)
    InMemoryListEngine.setRequest(Item("Two"), 2)
    InMemoryListEngine.setRequest(Item("Three"), 3)

    assert(InMemoryListEngine.items() == List(Item("One"), Item("Two"), Item("Three")))
  }

  it should "update requests" in {
    InMemoryListEngine.clear

    InMemoryListEngine.setRequest(Item("One"), 1)
    InMemoryListEngine.setRequest(Item("Two"), 2)
    InMemoryListEngine.setRequest(Item("Three"), 3)

    InMemoryListEngine.setRequest(Item("One"), 10)
    InMemoryListEngine.setRequest(Item("Two"), 20)
    InMemoryListEngine.setRequest(Item("Three"), 30)

    assert(InMemoryListEngine.requests()(Item("One")) == 10)
    assert(InMemoryListEngine.requests()(Item("Two")) == 20)
    assert(InMemoryListEngine.requests()(Item("Three")) == 30)
  }

  it should "remove requests" in {
    InMemoryListEngine.clear

    InMemoryListEngine.setRequest(Item("One"), 1)
    InMemoryListEngine.setRequest(Item("Two"), 2)
    InMemoryListEngine.setRequest(Item("Three"), 3)

    InMemoryListEngine.removeRequest(Item("One"))
    InMemoryListEngine.removeRequest(Item("Two"))
    InMemoryListEngine.removeRequest(Item("Three"))

    assert(InMemoryListEngine.requests().get(Item("One")) == None)
    assert(InMemoryListEngine.requests().get(Item("Two")) == None)
    assert(InMemoryListEngine.requests().get(Item("Three")) == None)
  }
}
