class Customer {
    private var customerName: String = ""
    private var customerNumber: Long = 0
    private var allOrder = mutableListOf<Pizza>()
    var totalBill: Double = 0.0
    var finalPrice: Double = 0.0


    val order = NewOrder()

    fun setName(name: String) {
        this.customerName = name
    }

    fun setNumber(num: Long) {
        this.customerNumber = num
    }

    fun setOrder() {
        val piz: Pizza = order.createNewPizza()
        allOrder.add(piz)
    }

    fun getName(): String {
        return customerName
    }

    fun getNumber(): Long {
        return customerNumber
    }

    fun getOrder(): List<Pizza> {
        return allOrder
    }


    fun viewPreviousOrders(){

    }

}