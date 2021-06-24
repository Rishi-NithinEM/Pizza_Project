class Orders {
    private var allOrder = mutableListOf<Pizza>()
    var totalBill: Double = 0.0
    var finalPrice: Double = 0.0


    val operation = Operations()

    fun createNewOrder() {
        val piz: Pizza = operation.createNewPizza()
        allOrder.add(piz)
    }

    fun getOrder(): List<Pizza>{
        return allOrder
    }
}