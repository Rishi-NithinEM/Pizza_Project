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
var Database = mutableListOf<Customer>()

fun main() {
    val operation = Operations()

    val sc = Scanner(System.`in`)
//    var Database = mutableListOf<Customer>()
    var option:Int
    var option2 : Int
    while (true) {
        println("\n\nHello Welcome To Pizza Shop \n1.Take a Order \n2.View Previous Orders\n3.Exit")
        option=sc.nextInt()
        if (option == 1) {
            println("\n1.New Customer\n2.Already a Customer")
            option2=sc.nextInt()
            if(option2 == 1){
                Database.add(operation.createNewCustomer(Customer()))
            }
            else if(option2 == 2) {
                println("Please Enter Your Phone Number")
                var number: Long=sc.nextLong()
                var cust: Customer =operation.checkifAlreadyCustomer(number)
                if(cust.getName().equals("")){
                    println("Sorry you are New Custmer")
                    Database.add(operation.createNewCustomer(cust))
                }
                else{
                    Database.add(operation.takeOrder(cust))
                }
            }
            continue
        } else if(option == 2){
            println("Please Enter Your Phone Number")
            var number: Long=sc.nextLong()
            var cust: Customer =operation.checkifAlreadyCustomer(number)
            if(cust.getName().equals("")){
                println("Sorry you are New Custmer, So no previous Order")
                //Database.add(operation.createNewCustomer(cust))
            }
            else{
                operation.printOrders(cust)
            }
        }
        else{
            break
        }
    }
}