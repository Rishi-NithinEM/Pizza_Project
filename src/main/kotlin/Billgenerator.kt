import java.util.*

class Billgenerator {
    val sc = Scanner(System.`in`)


    fun checkOffers(cust: Customer) {

        var mediumCount: Int = 0
        for (piz in cust.getOrder()) {
            cust.totalBill += piz.getRate()
            if (piz.getPizzaSize() == PizzaSize.MEDIUM)
                mediumCount++
        }

        var code: String = ""

        while (true) {
            println(
                "\n\nOffer available:\n1.10% off upto Rs.30 on Rs 200 and above, if the code “ZOHO” used\n2.20% off upto Rs. 100 on Rs. 400 and above, if the code “JUMBO” used\n3.Get any 2 medium sized pizzas for just Rs. 100 each. \n" +
                        "[Coupon not applicable if this offer applied],if the code \"MEDIUM\" used.\n\nEnter the Offer Code:"
            )
            code = sc.next()

            if (code.equals("ZOHO")) {
                if (cust.totalBill * 0.10 >= 30) {
                    cust.finalPrice = cust.totalBill - 30
                } else {
                    cust.finalPrice = cust.totalBill - cust.totalBill * 0.10
                }
                break
            } else if (code.equals("JUMBO")) {
                if (cust.totalBill >= 400) {
                    if (cust.totalBill * 0.20 >= 100) {
                        cust.finalPrice = cust.totalBill - 100
                    } else {
                        cust.finalPrice = cust.totalBill - cust.totalBill * 0.20
                    }
                    break
                } else {
                    println("Sorry this offer is not applicable for you, Please choose other Offer")
                    continue
                }

            } else if (code.equals("MEDIUM")) {
                if (mediumCount >= 2) {
                    cust.finalPrice = cust.totalBill - (mediumCount / 2) * 40
                } else {
                    println("Sorry this offer is not applicable for you, Please choose other Offer")
                    continue
                }
                break
            } else {
                println("Sorry enter a Correct Code!")
                continue
            }
        }
        cust.finalPrice = cust.finalPrice + cust.finalPrice * 0.12
    }

    fun printBill(cust: Customer) {
        println(cust.getName() + "\n" + cust.getNumber())
        for (piz in cust.getOrder()) {
            print(piz.getPizzaSize().name + "  " + piz.getPizzaCrust() + "  " + piz.getPizzaToppings() + "  Cheese:" + piz.getcheese())
            println("\n")
        }
        println("Total amount:" + cust.finalPrice)
    }
}