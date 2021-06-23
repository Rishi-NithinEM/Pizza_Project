import java.util.*;

class NewOrder() {

    val sc= Scanner(System.`in`)
    val bill= Billgenerator()


    fun createNewCustomer() : Customer{
        val cust = Customer()

        println("Enter Customer name :")
        cust.setName(sc.next())

        println("Enter Customer Phone Number")
        cust.setNumber(sc.nextLong())

        println("Adding a new Pizza")
        cust.setOrder()

        while(true){
            println("1.Wanna a add Another Pizza \nor \n2.Check Out")
            if(sc.nextInt()== 1) {
                cust.setOrder()
                continue
            }
            break
        }
        cust.setBill()
        bill.checkOffers(cust)
        bill.printBill(cust)

        return cust
    }


    fun createNewPizza() : Pizza{

        val pizza = Pizza()


        println("Choose a Pizza Size")
        for(sz in PizzaSize.values()){
            println(sz)
        }
        pizza.setpizzaType(PizzaSize.values()[sc.nextInt()-1])

        println("Now choose which type of Crust")
        for(sz in PizzaCurst.values()){
            println(sz)
        }
        pizza.setpizzaCrust(PizzaCurst.values()[sc.nextInt()-1])

        println("Now Add Toppings")
        li@while(true){
            for(sz in Topping.values()){
                println(sz)
            }
            pizza.setpizzaTopping(Topping.values()[sc.nextInt()-1])
            println("Wanna add more Topping? (Y/N)")
            var ch : Char = sc.next().single()
            if(ch=='y' || ch=='Y'){
                continue@li
            }
            else
                break
        }

        println("Do you wanna add Cheese? (Y/N)")
        var ch : Char = sc.next().single()
        if(ch=='y' || ch=='Y'){
            pizza.setCheese(true)
        }

        pizza.setRate()
        return pizza

    }
}