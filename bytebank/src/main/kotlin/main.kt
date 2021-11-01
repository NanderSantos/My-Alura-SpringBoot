fun main() {

    println("\nWelcome to ByteBank!\n")

    val accountAlex = Account()
    accountAlex.setHolder("Alex")
    accountAlex.setNumber(1)
    accountAlex.setBalance(100.0)

    val accountFran = Account()

    accountFran.setHolder("Fran")
    accountFran.setNumber(2)
    accountFran.setBalance(200.0)

    println(accountAlex.toString())
    println(accountFran.toString())

    if(accountAlex.withdraw(200.0)) println("Done!")
    else println("Failed!")

    if(accountFran.deposit(1000.0)) println("Done!")
    else println("Failed!")

    if(accountAlex.transfer(50.0, accountFran)) println("Done!")
    else println("Failed!")

    println(accountAlex.toString())
    println(accountFran.toString())
}

class Account {

    private var holder = ""
    private var number = 0
    private var balance = 0.0

    override fun toString(): String {

        return "Conta -> " +
                "Titular: ${this.holder}, " +
                "Número: ${this.number}, " +
                "Saldo: ${this.balance}"
    }

    fun deposit(value: Double): Boolean {

        this.balance += value
        return true
    }

    fun withdraw(value: Double): Boolean {

        if(this.balance >= value) {

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

    fun getHolder(): String {

        return this.holder
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