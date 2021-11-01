fun main() {

    println("\nWelcome to ByteBank!\n")

    val accountAlex = Account(holder = "Alex")
    accountAlex.deposit(100.0)

    val accountFran = Account(holder = "Fran", number = 2)
    accountFran.deposit(value = 200.0)

    println(accountAlex.toString())
    println(accountFran.toString())

    if (accountAlex.withdraw(200.0)) println("Done!")
    else println("Failed!")

    if (accountFran.deposit(1000.0)) println("Done!")
    else println("Failed!")

    if (accountAlex.transfer(value = 50.0, to = accountFran)) println("Done!")
    else println("Failed!")

    println(accountAlex.toString())
    println(accountFran.toString())
}

class Account(

    val holder: String,
    val number: Int = 1,

) {

    var balance = 0.0
        private set

    init {

        println("Criando uma conta para o usuário ${this.holder} com o número ${this.number}")
    }

    override fun toString(): String {

        return "Conta -> " +
                "Titular: ${this.holder}, " +
                "Número: ${this.number}, " +
                "Saldo: ${this.balance}"
    }

    fun deposit(value: Double): Boolean {

        if (value > 0) {

            this.balance += value
            return true
        }

        return false
    }

    fun withdraw(value: Double): Boolean {

        if (this.balance >= value) {

            this.balance -= value
            return true
        }

        return false
    }

    fun transfer(value: Double, to: Account): Boolean {

        if (this.balance >= value) {

            this.balance -= value
            to.withdraw(value)

            return true
        }

        return false
    }
}

fun variables() {

    val holder = "Alex"
    val accountNumber = 1000
    var accountBalance = 0.0
    accountBalance += 100

    println("titular: $holder")
    println("numeroConta: $accountNumber")
    println("saldo: $accountBalance")
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