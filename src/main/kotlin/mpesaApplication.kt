import java.util.*
data class User (
        val name : String,
        val PIN : Int,
        val phoneNumber : Int,
        var accountBalance : Double
              )

fun userRegistration (): ArrayList<User>{
        val scan = Scanner(System.`in`)

        println(" Option Register users")
        val users = ArrayList<User>()

        println("Enter your name : ")
        val userName = scan.nextLine()

        println("Set your Pin : ")
        val userPin = scan.nextInt()

        println("Enter your Phone number : ")
        val userPhoneNo = scan.nextInt()

        println("Enter your account Balance in Ksh : ")
        val accountBal = scan.nextDouble()

        val userRegObject = User(userName,userPin,userPhoneNo,accountBal)
        users.add(userRegObject)

 return users
}
fun deposit (userDeposit : User){
        val scan = Scanner(System.`in`)

        println(" Option Deposit ")

        println("Enter the amount to deposit in Ksh : ")
        val deposit = scan.nextDouble()

        println("Enter the user pin : ")
        val userPin = scan.nextInt()

        if(userPin == userDeposit.PIN){
        userDeposit.accountBalance += deposit
        println("You have deposited Ksh $deposit . Your new account Balance is Ksh ${userDeposit.accountBalance}")
        }else{
        println("The PIN entered is INVALID!. Deposit failed.")
        }
}
fun sendMoney (userSendMoney : User){
     val scan = Scanner(System.`in`)

     println("Option Send Money")

     println("Enter Receiver's phone Number : ")
     val receiverPhoneNo = scan.nextInt()

     println("Enter Amount you want to Send in Ksh : ")
     val amountToSend = scan.nextDouble()

     println("Enter the user pin : ")
     val userPin = scan.nextInt()

    if(userPin == userSendMoney.PIN && userSendMoney.accountBalance > amountToSend){
     userSendMoney.accountBalance -= amountToSend
     println("You have Successfully transferred Ksh $amountToSend to Phone Number $receiverPhoneNo. Your new account Balance is Ksh ${userSendMoney.accountBalance} ")
    }else{
     println(" Transaction failed. Invalid PIN! or recharge your account Balance is too low to complete the transaction.")
    }
}
fun withdrawCash (userWithdraw : User ){
    val scan = Scanner(System.`in`)

    println(" Option Withdraw ")

    println("Enter Amount you want to withdraw in Ksh : ")
    val amountToWithdraw = scan.nextDouble()

    println("Enter the user pin : ")
    val userPin = scan.nextInt()

    if(userPin == userWithdraw.PIN && userWithdraw.accountBalance > amountToWithdraw){
     userWithdraw.accountBalance -= amountToWithdraw
     println("You have successfully withdrawn Ksh $amountToWithdraw. Your new account Balance is Ksh ${userWithdraw.accountBalance}")
    }else{
     println("Invalid PIN! or your Account Balance is to low to complete the withdrawal.")
    }
}
fun buyGoods (userBuyGoods : User){
    val scan = Scanner(System.`in`)

    println(" Option Buy Goods.")

    println("Enter amount for Goods to buy in Ksh:")
    val goodsAmount = scan.nextInt()

    println("Enter the user pin : ")
    val userPin = scan.nextInt()

    if(userPin == userBuyGoods.PIN && goodsAmount < userBuyGoods.accountBalance){
        userBuyGoods.accountBalance -= goodsAmount
        println("You have successfully purchased Goods worth Ksh $goodsAmount. Your new account Balance is ${userBuyGoods.accountBalance}")
    }else{
        println("You have entered Invalid PIN! or your account Balance is to low to complete the transaction.")
    }
}
fun buyAirtime (userBuyAirtime : User){
    val scan = Scanner(System.`in`)

    println("Option Buy Airtime.")

    println("Enter amount of Credit to buy in Ksh:")
    val airtimeAmount = scan.nextInt()

    println("Enter the user pin : ")
    val userPin = scan.nextInt()

    if(userPin == userBuyAirtime.PIN && airtimeAmount < userBuyAirtime.accountBalance){
        userBuyAirtime.accountBalance -= airtimeAmount
        println("You have successfully purchase Ksh $airtimeAmount airtime. Your new account Balance is ${userBuyAirtime.accountBalance}")
    }else{
        println("You have entered and Invalid PIN! or your Account is to low to complete the transaction.")
    }
}
fun main (){
       val users = userRegistration()

       println("The Details of the user are :")
       users.forEach{user ->
       println("Name : ${user.name}, PIN : ${user.PIN}, phoneNumber : ${user.phoneNumber}, Account Balance : ${user.accountBalance}")
        }

       if (users.isNotEmpty()) {
       deposit(users[0])
       }

       if(users.isNotEmpty()){
        sendMoney(users[0])
       }

       if(users.isNotEmpty()){
        withdrawCash(users[0])
       }

       if(users.isNotEmpty()){
           buyGoods(users[0])
       }

       if(users.isNotEmpty()){
          buyAirtime(users[0])
       }
}