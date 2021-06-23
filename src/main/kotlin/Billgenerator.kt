import java.util.*

class Billgenerator {
    val sc= Scanner(System.`in`)

    fun checkOffers(cust: Customer){

        var x: Int=0
//        var bool : Boolean=false
        var va: Int=0
        println("Offer available:\n1.10% off upto Rs.30 on Rs 200 and above, if the code “ZOHO” used\n2.20% off upto Rs. 100 on Rs. 400 and above, if the code “JUMBO” used\n3.Get any 2 medium sized pizzas for just Rs. 100 each. \n" +
                "[Coupon not applicable if this offer applied]")


        if(cust.totalBill >= 400)
            x=1

        else if(cust.totalBill >= 200)
            x=2

        if(cust.mediumCount >= 2 ) {
            if(x==1){
                println("Offer 2 and 3 are Applicable for you Choose either One (2/3)")
                va=sc.nextInt()
                if(va == 2){
                    if(cust.totalBill*0.2 < 100)
                    {
                        cust.finalPrice= (cust.totalBill-cust.totalBill* 0.2) *0.88
                    }
                    else
                        cust.finalPrice = (cust.totalBill -100)* 0.88
                }
                else
                    cust.finalPrice= (cust.totalBill - (cust.mediumCount/2)*40)* 0.88
            }
            else{
                println("Offer 1 and 3 are Applicable for you Choose either One (1/3)")
                va=sc.nextInt()
                if(va == 1){
                    if(cust.totalBill*0.1 < 30)
                    {
                        cust.finalPrice=(cust.totalBill- cust.totalBill* 0.1) *0.88
                    }
                    else
                        cust.finalPrice = (cust.totalBill -30)* 0.88
                }
                else
                    cust.finalPrice= (cust.totalBill - (cust.mediumCount/2)*40) *0.88
            }
        }

        else{
            if(x==1){
                if(cust.totalBill*0.1 < 30)
                {
                    cust.finalPrice= (cust.totalBill-cust.totalBill* 0.1) *0.88
                }
                else
                    cust.finalPrice = (cust.totalBill -30)* 0.88
            }
            else{
                if(cust.totalBill*0.2 < 100)
                {
                    cust.finalPrice= (cust.totalBill-cust.totalBill* 0.2) *0.88
                }
                else
                    cust.finalPrice = (cust.totalBill -100)* 0.88
            }
        }

    }

    fun printBill(cust: Customer){
        println(cust.getName()+"\n"+cust.getNumber())
        for(piz in cust.getOrder()){
            print(piz.getPizzaSize().name+"  "+piz.getPizzaCrust()+"  "+piz.getPizzaToppings()+"  Cheese:"+piz.getCheese())
            println("\n")
        }
        println("Total amount:"+cust.finalPrice)
    }
}