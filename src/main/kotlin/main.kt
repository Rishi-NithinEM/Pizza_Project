import java.util.*

enum class PizzaSize(var size: Int, var rate: Int) {
    REGULAR(8, 100),
    MEDIUM(10, 120),
    LARGE(12, 150)

}

enum class PizzaCurst(var rate: Int) {
    HANDTOSSED(0),
    WHEATTHINCHRUST(30),
    CHEESEBURST(40)
}

enum class Topping(var rate: Int) {
    ORNION(20),
    OLIVE(30),
    BABYCORN(40),
    TIKKACHICKEN(40),
    BBQCHICKEN(50),
    SPICYCHICKEN(60)
}

fun main() {
    val newOrder = NewOrder()

    val sc = Scanner(System.`in`)
    var Database = mutableListOf<Customer>()
    var option:Int
    while (true) {
        println("\n\nHello Welcome To Pizza Shop \n1.Take a Order \n2.View Previous Orders\n3.Exit")
        option=sc.nextInt()
        if (option == 1) {
            Database.add(newOrder.createNewCustomer())
            continue
        } else if(option == 2){

        }
    }
}