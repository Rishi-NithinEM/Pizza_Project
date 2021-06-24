class Pizza(val pizzaType: PizzaSize, val pizzacrust: PizzaCurst , val pizzaTopping: List<Topping>, val cheese: Boolean=false) {

    private var Rate: Int = 0

    fun setRate() {
        Rate = pizzaType.rate + pizzacrust.rate
        if (cheese)
            Rate += 20
        for (tt in pizzaTopping)
            Rate = Rate + tt.rate
    }
    fun getcheese(): Boolean {
        return cheese
    }

    fun getRate(): Int {
        return Rate
    }

    fun getPizzaSize(): PizzaSize {
        return pizzaType
    }

    fun getPizzaCrust(): PizzaCurst {
        return pizzacrust
    }

    fun getPizzaToppings(): List<Topping> {
        return pizzaTopping
    }



}