import java.util.*

enum class PizzaSize(var size: Int, var rate: Int){
    REGULAR(8,100),
    MEDIUM(10,120),
    LARGE(12,150)

}

enum class PizzaCurst(var rate: Int){
    HANDTOSSED(0),
    WHEATTHINCHRUST(30),
    CHEESEBURST(40)
}

enum class Topping(var rate: Int){
    ORNION(20),
    OLIVE(30),
    BABYCORN(40),
    TIKKACHICKEN(40),
    BBQCHICKEN(50),
    SPICYCHICKEN(60)
}

fun main() {
    val newOrder = NewOrder()

    val sc= Scanner(System.`in`)
    var Database = mutableListOf<Customer>()
    while(true) {
        println("Hello Welcome To Pizza Shop \n1.Add a New Customer \n2.View Previous Orders")
        if(sc.nextInt() == 1) {
            Database.add(newOrder.createNewCustomer())
            continue
        }
        else{
            for(cust in Database){
                println(cust.getName()+ " " + cust.finalPrice)
            }
        }
    }
}