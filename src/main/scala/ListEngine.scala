case class Item(name: String)

trait ListEngine {
  def items(): List[Item]
  def requests(): Map[Item, Int]
  def setRequest(item: Item, amount: Int)
  def removeRequest(item: Item)
}

object InMemoryListEngine extends ListEngine {

  var requestMap: Map[Item, Int] = Map()

  override def items(): List[Item] = requestMap.keys.toList

  override def requests(): Map[Item, Int] = requestMap

  override def setRequest(item: Item, amount: Int): Unit = requestMap = requestMap + (item -> amount)

  override def removeRequest(item: Item): Unit = requestMap = requestMap - item

  def clear = requestMap = Map()

  def populateSampleRequests = {
    InMemoryListEngine.clear
    InMemoryListEngine.setRequest(Item("Leche entera 1L"), 1)
    InMemoryListEngine.setRequest(Item("Leche 1% 1L"), 1)
    InMemoryListEngine.setRequest(Item("Tortillas"), 3)
    InMemoryListEngine.setRequest(Item("Salsa verde Herdez"), 2)
    InMemoryListEngine.setRequest(Item("Chobani Vainilla"), 2)
    InMemoryListEngine.setRequest(Item("Yogurt Danone Durazno"), 4)
    InMemoryListEngine.setRequest(Item("Yogurt Danone Fresa"), 1)
    InMemoryListEngine.setRequest(Item("Cabeza de brocoli"), 3)
    InMemoryListEngine.setRequest(Item("Zanahoria"), 4)
    InMemoryListEngine.setRequest(Item("Blueberry"), 1)
    InMemoryListEngine.setRequest(Item("Blackberry"), 1)
  }
}

