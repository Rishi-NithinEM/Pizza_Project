class Pizza {
    private var pizzaType: PizzaSize = PizzaSize.REGULAR
    private var pizzaCrust: PizzaCurst = PizzaCurst.HANDTOSSED
    private var pizzaTopping = mutableListOf<Topping>()
    private var cheese: Boolean = false
    private var Rate: Int = 0

    fun setpizzaType(pt: PizzaSize) {
        this.pizzaType = pt
    }

    fun setpizzaCrust(pc: PizzaCurst) {
        this.pizzaCrust = pc
    }

    fun setpizzaTopping(pt: Topping) {
        this.pizzaTopping.add(pt)
    }

    fun setCheese(ch: Boolean) {
        this.cheese = ch
    }

    fun setRate() {
        Rate = pizzaType.rate + pizzaCrust.rate
        if (cheese)
            Rate += 20
        for (tt in pizzaTopping)
            Rate = Rate + tt.rate
    }

    fun getRate(): Int {
        return Rate
    }

    fun getPizzaSize(): PizzaSize {
        return pizzaType
    }

    fun getPizzaCrust(): PizzaCurst {
        return pizzaCrust
    }

    fun getPizzaToppings(): List<Topping> {
        return pizzaTopping
    }

    fun getCheese(): Boolean {
        return cheese
    }

}