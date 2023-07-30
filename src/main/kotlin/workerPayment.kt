@file:Suppress("UNUSED_EXPRESSION")

import java.util.*
fun workerRegistration (name : String ,rateOfPay : Double ,noOfHours : Double , nssfAmount : Double){

    println("Enter your name : $name")
    println("Enter your rate of Pay  : $rateOfPay")
    println("Enter number of hours worked : $noOfHours")
    println("Enter your NSSF Amount : $nssfAmount")

    val basicSalary = basicSalary(rateOfPay, noOfHours)
    println("Your Basic Salary is : $basicSalary")

    val overtimePay = overtimePay(noOfHours, rateOfPay)
    println("Your Overtime Pay is : $overtimePay")

    val grossSalary = grossSalary(rateOfPay,noOfHours)
    println("Your Gross Salary is : $grossSalary")

    val netSalary = netSalary(rateOfPay , noOfHours , nssfAmount)
    println("Your  Net Salary is : $netSalary ")


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
    return if (noOfHours > 160)
            (noOfHours - 160) * 1.3 * rateOfPay
    else 0.0
}

fun netSalary (rateOfPay: Double,noOfHours: Double,nssfAmount: Double) : Any{

    val grossSalary = grossSalary(rateOfPay,noOfHours)
    val paye = grossSalary * 0.15

    return if(nssfAmount > grossSalary){
        grossSalary - paye
    }else{
        grossSalary - nssfAmount - paye
    }

}

data class UserInput (
    val workerName : String,
    val workerRateOfPay : Double,
    val workerHours : Double,
    val nssfAmount: Double
)

fun verifyName() : String{

    val scan = Scanner(System.`in`)

    println("Enter your name : ")
    val workerName  = scan.nextLine()

    return if(!workerName.matches(Regex("^[a-zA-Z]*$"))){
        "null"
    }else{
        workerName
    }
}

fun getUserInput() : UserInput{

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

        return UserInput(workerName,workerRateOfPay,workerHours,nssfAmount)
}
fun storeWorkerData (name: String,nssfAmount: Double,noOfHours: Double,rateOfPay: Double) : ArrayList<UserInput>{

    val workerData = ArrayList<UserInput> ()

    workerData.add(UserInput(name,nssfAmount,noOfHours,rateOfPay))

    return workerData
}
data class WorkerSalary(
    val basicSalary: Double,
    val grossSalary: Double,
    val overtimePay: Double,
    val netSalary: Any
)

fun workerSalaryDetails(rateOfPay : Double ,noOfHours : Double , nssfAmount : Double) : WorkerSalary {

    val basicSalary = basicSalary(rateOfPay, noOfHours)
    val overtimePay = overtimePay(noOfHours, rateOfPay)
    val grossSalary = grossSalary(rateOfPay,noOfHours)
    val netSalary = netSalary(rateOfPay , noOfHours , nssfAmount)

    return WorkerSalary(basicSalary,grossSalary,overtimePay,netSalary)
}

fun storeWorkerSalary(rateOfPay : Double ,noOfHours : Double , nssfAmount : Double) : ArrayList<WorkerSalary>{

    val salaryDetails = ArrayList<WorkerSalary>()
    val salary = workerSalaryDetails(rateOfPay,noOfHours,nssfAmount)

    salaryDetails.add(salary)

    return salaryDetails
}
fun main() {

        val (name,rateOfPay,noOfHours,nssfAmount) = getUserInput()

        workerRegistration(name,rateOfPay , noOfHours , nssfAmount)
        workerSalaryDetails(rateOfPay,noOfHours,nssfAmount)

        val userData = storeWorkerData(name,nssfAmount,noOfHours,rateOfPay)
        println("Worker Registration data is : $userData")

        val salaryData = storeWorkerSalary(rateOfPay,noOfHours,nssfAmount)
        println("Worker Salary data is : $salaryData")
}

