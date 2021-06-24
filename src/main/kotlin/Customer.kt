class Customer {
    private var customerName: String = ""
    private var customerNumber: Long = 0
    private var allOrder = mutableListOf<Orders>()



    fun setName(name: String) {
        this.customerName = name
    }

    fun setNumber(num: Long) {
        this.customerNumber = num
    }

    fun setOrder(orders: Orders) {

        allOrder.add(orders)
    }

    fun getName(): String {
        return customerName
    }

    fun getNumber(): Long {
        return customerNumber
    }

    fun getOrder(): List<Orders> {
        return allOrder
    }


}