import java.util.*

class Operations() {

    val sc = Scanner(System.`in`)
    val bill = Billgenerator()

    fun checkifAlreadyCustomer(Number: Long): Customer {
        for (data in Database) {
            if (Number == data.getNumber()) {
                return data
            }
        }
        return Customer()
    }

    fun takeOrder(cust: Customer): Customer {

        val orders = Orders()

        println("Adding a new Pizza")
        orders.createNewOrder()

        while (true) {
            println("1.Wanna a add Another Pizza \nor \n2.Check Out")
            if (sc.nextInt() == 1) {
                orders.createNewOrder()
                continue
            }
            break
        }
        //cust.setBill()
        cust.setOrder(orders)
        bill.checkOffers(orders)
        bill.printBill(cust, orders)

        return cust

    }

    fun createNewCustomer(cust: Customer): Customer {
//        val cust = Customer()
        val orders = Orders()
        val number: Long

        println("Enter Customer name :")
        cust.setName(sc.next())

        println("Enter Customer Phone Number")
        number = sc.nextLong()


        var customer: Customer = checkifAlreadyCustomer(number)
        if (customer.getName().equals("")) {


            cust.setNumber(number)

            println("Adding a new Pizza")
            orders.createNewOrder()

            while (true) {
                println("1.Wanna a add Another Pizza \nor \n2.Check Out")
                if (sc.nextInt() == 1) {
                    orders.createNewOrder()
                    continue
                }
                break
            }
            //cust.setBill()
            cust.setOrder(orders)
            bill.checkOffers(orders)
            bill.printBill(cust, orders)

            //return cust
        }
        else{
            takeOrder(customer)
        }
        return cust
    }


    fun createNewPizza(): Pizza {

        val pizzaType: PizzaSize
        val pizzaCrust: PizzaCurst
        val pizzaTopping = mutableListOf<Topping>()
        var cheese: Boolean = false

        println("Choose a Pizza Size")
        for (sz in PizzaSize.values()) {
            println(sz)
        }
        pizzaType = PizzaSize.values()[sc.nextInt() - 1]

        println("Now choose which type of Crust")
        for (sz in PizzaCurst.values()) {
            println(sz)
        }
        pizzaCrust = PizzaCurst.values()[sc.nextInt() - 1]

        println("Now Add Toppings")
        li@ while (true) {
            for (sz in Topping.values()) {
                println(sz)
            }
            pizzaTopping.add(Topping.values()[sc.nextInt() - 1])
            println("Wanna add more Topping? (Y/N)")
            var ch: Char = sc.next().single()
            if (ch == 'y' || ch == 'Y') {
                continue@li
            } else
                break
        }

        println("Do you wanna add Cheese? (Y/N)")
        var ch: Char = sc.next().single()
        if (ch == 'y' || ch == 'Y') {
            cheese = true
        }
        val pizza = Pizza(pizzaType, pizzaCrust, pizzaTopping, cheese)

        pizza.setRate()

        return pizza

    }

    fun printOrders(cust: Customer) {
        println("\n\nName: " + cust.getName() + "\nPhone Number :" + cust.getNumber())
        var i: Int = 0
        for (order in cust.getOrder()) {
            println("\nOrder number:" + (++i))
            for (piz in order.getOrder()) {
                print(piz.getPizzaSize().name + "  " + piz.getPizzaCrust() + "  " + piz.getPizzaToppings() + "  Cheese:" + piz.getcheese())
            }
            println("\nBill Amount: " + order.finalPrice)
        }
    }

}