fun main(args: Array<String>) {

    runOperation()

}

var allMoney = mutableMapOf<String, Int>(
    "100" to 10,
    "500" to 4,
    "1000" to 3,
    "5000" to 2
) //купюры в терминале (номинал - значение)

var newMoney = mutableMapOf<String, Int>("100" to 10, "500" to 4, "1000" to 3, "5000" to 2)

fun getMoneyFromATM(giveOut: Int) {
    var sum = giveOut
    while (sum > 0) {                                       //расчет
        if (sum - 5000 >= 0 && allMoney["5000"]!! > 0) {
            sum -= 5000
            allMoney["5000"] = allMoney["5000"]!! - 1
        } else if (sum - 1000 >= 0 && allMoney["1000"]!! > 0) {
            sum -= 1000
            allMoney["1000"] = allMoney["1000"]!! - 1
        } else if (sum - 500 >= 0 && allMoney["500"]!! > 0) {
            sum -= 500
            allMoney["500"] = allMoney["500"]!! - 1
        } else if (sum - 100 >= 0 && allMoney["100"]!! > 0) {
            sum -= 100
            allMoney["100"] = allMoney["100"]!! - 1
        } else {
            sum = -1

        }

    }
    if (sum == 0) {
        for ((key) in allMoney) {
            newMoney[key] = allMoney[key]!!
        }

        println("The amount was issued\n\n${showAllMoney(allMoney)}")

    } else {
        println("It is impossible to issue this amount\n\n")

        for ((key) in allMoney) {
            allMoney[key] = newMoney[key]!!
        }
        println(showAllMoney(allMoney))

    }
}

fun showAllMoney(map: Map<String, Int>): String {

    return ("The number of remaining denominations of banknotes:\n" +
            "${map["100"]!!} pcs of nominal value 100\n" +
            "${map["500"]!!} pcs of nominal value 500\n" +
            "${map["1000"]!!} pcs of nominal value 1000\n" +
            "${map["5000"]!!} pcs of nominal value 5000\n")

}

fun runOperation() {


    println("Write the sum:")

    val s = readln().toInt()

    getMoneyFromATM(s)

    println("Would you like to enter a different amount? (press y/n)")

    if (readln() == "y")
        runOperation()


}
