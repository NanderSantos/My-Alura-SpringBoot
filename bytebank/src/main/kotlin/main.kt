fun main() {

    println("\nBem vindo ao ByteBank!\n")

    val holder = "Alex"
    val accountNumber = 1000
    var accountBalance = 0.0
    accountBalance += 100

    println("titular: $holder")
    println("numeroConta: $accountNumber")
    println("saldo: $accountBalance")

    testConditions(accountBalance)
    loops()
}

fun testConditions(accountBalance: Double) {

    println("\ntestConditions:")

    when {

        accountBalance > 0.0 -> println("Conta com saldo positivo")
        accountBalance == 0.0 -> println("Conta com saldo negativo")
        else -> println("Conta com saldo nulo")
    }
}

fun loops() {

    println("\nloops:")

    for (i in 1..5 step 2) println("Contando de forma crescente: $i")
    for (i in 1 until 5 step 1) println("Contando de forma crescente: $i")
    for (i in 5 downTo 1 step 2) println("Contando de forma decrescente: $i")
}