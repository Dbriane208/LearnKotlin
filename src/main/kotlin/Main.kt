import java.util.*
fun workerRegistration (name : String ,
                        rateOfPay : Double ,
                        noOfHours : Double ,
                        nssfAmount : Double,
                        PAYE : Double){
    println("Enter your name : $name")
    println("Enter your rate of Pay  : $rateOfPay")
    println("Enter number of hours worked : $noOfHours")
    println("Enter your NSSF Amount : $nssfAmount")
    println("Enter your PAYE Amount : $PAYE")
}

fun workerSalary (rateOfPay: Double,
                  noOfHours: Double,
                  nssfAmount: Double,
                  PAYE: Double) : Double{

    val basicSalary = rateOfPay * noOfHours
    val overtimePay = (noOfHours - 160) * 1.3 * rateOfPay
    val grossSalary = basicSalary + overtimePay

    return grossSalary - nssfAmount - PAYE
}

fun getUserInput() : Triple<String,Double,Double>{
    val scan = Scanner(System.`in`)

    println("Enter your name : ")
    val workerName = readln()

    println("Enter your rate of Pay  : ")
    val workerRateOfPay = scan.nextDouble()

    println("Enter number of hours worked : ")
    val workerHours = scan.nextDouble()

    return Triple(workerName,workerRateOfPay,workerHours)
}

fun main() {
    val (name,rateOfPay,noOfHours) = getUserInput()

    val nssfAmount = 100.0
    val paye = 100.0

    workerRegistration(name,rateOfPay , noOfHours , nssfAmount , paye )
    val netPay = workerSalary(rateOfPay , noOfHours , nssfAmount , paye)
    println("Your  netPay is : $netPay ")

}
