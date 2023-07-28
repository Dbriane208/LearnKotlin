import java.lang.NumberFormatException
import java.util.*
import javax.management.ValueExp

fun workerRegistration (name : String ,rateOfPay : Double ,noOfHours : Double , nssfAmount : Double){

    println("Enter your name : $name")
    println("Enter your rate of Pay  : $rateOfPay")
    println("Enter number of hours worked : $noOfHours")
    println("Enter your NSSF Amount : $nssfAmount")

}
fun grossSalary (rateOfPay: Double,noOfHours: Double):Double{

    val basicSalary = basicSalary(rateOfPay, noOfHours)
    val overtimePay = overtimePay(noOfHours, rateOfPay)

    return basicSalary + overtimePay
}

fun basicSalary(rateOfPay: Double,noOfHours: Double) : Double{

    return rateOfPay * noOfHours
}
fun overtimePay (noOfHours: Double,rateOfPay: Double) : Double{
    if (noOfHours > 160){
        return (noOfHours - 160) * 1.3 * rateOfPay
    }else{
        return 0.0
    }
}
fun netSalary (rateOfPay: Double,noOfHours: Double,nssfAmount: Double) : Any{

    val grossSalary = grossSalary(rateOfPay,noOfHours)
    val paye = grossSalary * 0.15

    if(nssfAmount > grossSalary){
        return grossSalary - paye
    }else{
        return grossSalary - nssfAmount - paye
    }

}

data class userInput (
    val workerName : String,
    val workerRateOfPlay : Double,
    val workerHours : Double,
    val nssfAmount: Double
)

fun verifyName() : String{

    val scan = Scanner(System.`in`)

    println("Enter your name : ")
    val workerName  = scan.nextLine()

    if(!workerName.matches(Regex("^[a-zA-Z]*$"))){
        return "null"
    }else{
      return  workerName
    }
}
fun getUserInput() : userInput{

        val scan = Scanner(System.`in`)

        val workerName  = verifyName()
        if (workerName == "null"){
            println("Name must be a String! eg. Daniel")
            System.exit(0)
        }else{
            workerName
        }

        println("Enter your rate of Pay  : ")
        val workerRateOfPay = scan.nextDouble()

        println("Enter number of hours worked : ")
        val workerHours = scan.nextDouble()

        println("Enter the NSSF Amount: ")
        val nssfAmount = scan.nextDouble()

        return userInput(workerName,workerRateOfPay,workerHours,nssfAmount)
}

fun main() {

        val (name,rateOfPay,noOfHours,nssfAmount) = getUserInput()

        workerRegistration(name,rateOfPay , noOfHours , nssfAmount  )

        val basicSalary = basicSalary(rateOfPay, noOfHours)
        println("Your Basic Salary is : $basicSalary")

        val overtimePay = overtimePay(noOfHours, rateOfPay)
        println("Your Overtime Pay is : $overtimePay")

        val grossSalary = grossSalary(rateOfPay,noOfHours)
        println("Your Gross Salary is : $grossSalary")

        val netSalary = netSalary(rateOfPay , noOfHours , nssfAmount)
        println("Your  Net Salary is : $netSalary ")

}
