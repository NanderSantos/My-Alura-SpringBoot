fun main() {

    println("\nBem vindo ao ByteBank!\n")

    // variables()
    // testConditions(100.0)
    // loops()

    val accountAlex = Account()
    accountAlex.holder = "Alex"
    accountAlex.accountNumber = 1
    accountAlex.accountBalance = 100.0

    val accountFran = Account()
    accountFran.holder = "Fran"
    accountFran.accountNumber = 2
    accountFran.accountBalance = 200.0

    println(accountAlex.toString())
    println(accountFran.toString())

    accountAlex.withdraw(10.0)
    accountFran.deposit(1000.0)
    accountAlex.transfer(50.0, accountFran)

    println(accountAlex.toString())
    println(accountFran.toString())
}

class Account {

    var holder = ""
    var accountNumber = 0
    var accountBalance = 0.0

    override fun toString(): String {

        return "Titular: ${this.holder}, Conta: ${this.accountNumber}, Saldo: ${this.accountBalance}"
    }

    fun deposit(value: Double) {

        this.accountBalance += value
    }

    fun withdraw(value: Double) {

        this.accountBalance -= value
    }

    fun transfer(value: Double, to: Account) {

        this.accountBalance -= value
        to.withdraw(value)
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