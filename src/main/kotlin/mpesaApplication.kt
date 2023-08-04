@file:Suppress("UNUSED_EXPRESSION")

import java.util.*
data class User (
    val name : String,
    val pin : String,
    val phoneNumber : String,
    var accountBalance : Double
              )
fun verifyUserNameIsString () : String {
    val scan = Scanner(System.`in`)

    println("Enter your name eg Daniel : ")
    val userName = scan.nextLine()

    return if(!userName.matches(Regex("^[a-zA-Z]*$"))){
        "null"
    }else{
        userName

    }
}
fun verifyUserPinSize() :String {
    val scan = Scanner(System.`in`)

    println("Set your 4-digits Pin : ")
    val userPin = scan.nextLine()

    return if(userPin.length == 4 && userPin.isNotEmpty()){
        userPin
    }else{
        "Invalid"
    }
}
fun verifyPhoneNumberLength() : String{
    val scan = Scanner(System.`in`)

    println("Enter your 10-digits Phone number (07..): ")
    val userPhoneNo = scan.nextLine()

    return if(userPhoneNo.length == 10 && userPhoneNo.isNotEmpty() && userPhoneNo.startsWith("07")){
        userPhoneNo
    }else{
        "null"
    }
}
fun userRegistration (): ArrayList<User>{
        val scan = Scanner(System.`in`)
        val users = ArrayList<User>()

        val userName = verifyUserNameIsString()
        if(userName != "null"){
            userName
        }else{
            println("Name must be a string! ")
            System.exit(0)
        }

        val userPin = verifyUserPinSize()
        if(userPin != "Invalid"){
            userPin
        }else{
            println("The userPin must be four digits!")
            System.exit(0)
        }

        val userPhoneNo = verifyPhoneNumberLength()
        if(userPhoneNo != "null"){
            userPhoneNo
        }else{
            println("User phoneNumber should be 10 digits or should start with 07... !")
            System.exit(0)
        }

        println("Enter your account Balance in Ksh : ")
        val accountBal = scan.nextDouble()

        val userRegObject = User(userName,userPin,userPhoneNo,accountBal)
        users.add(userRegObject)

 return users
}
fun deposit (userDeposit : User){
        val scan = Scanner(System.`in`)

        println("Enter the amount to deposit in Ksh : ")
        val deposit = scan.nextDouble()

        println("Enter the user pin : ")
        val userPin = readln()

        if(userPin == userDeposit.pin){
        userDeposit.accountBalance += deposit
        println("You have deposited Ksh $deposit . Your new account Balance is Ksh ${userDeposit.accountBalance}")
        }else{
        println("The PIN entered is INVALID!. Deposit failed.")
        }
}
fun sendMoney (userSendMoney : User){
       val scan = Scanner(System.`in`)

       println("Enter Receiver's phone Number : ")
       val receiverPhoneNo = scan.nextInt()

       println("Enter Amount you want to Send in Ksh : ")
       val amountToSend = scan.nextDouble()

       println("Enter the user pin : ")
       val userPin = readln()

      if(userPin == userSendMoney.pin && userSendMoney.accountBalance > amountToSend){
      userSendMoney.accountBalance -= amountToSend
      println("You have Successfully transferred Ksh $amountToSend to Phone Number $receiverPhoneNo. Your new account Balance is Ksh ${userSendMoney.accountBalance} ")
      }else{
       println(" Transaction failed. Invalid PIN! or recharge your account Balance is too low to complete the transaction.")
      }
}
fun withdrawCash (userWithdraw : User ){
      val scan = Scanner(System.`in`)

      println("Enter Amount you want to withdraw in Ksh : ")
      val amountToWithdraw = scan.nextDouble()

      println("Enter the user pin : ")
      val userPin = readln()

      if(userPin == userWithdraw.pin && userWithdraw.accountBalance > amountToWithdraw){
       userWithdraw.accountBalance -= amountToWithdraw
      println("You have successfully withdrawn Ksh $amountToWithdraw. Your new account Balance is Ksh ${userWithdraw.accountBalance}")
      }else{
       println("Invalid PIN! or your Account Balance is to low to complete the withdrawal.")
      }
}
fun buyGoods (userBuyGoods : User){
     val scan = Scanner(System.`in`)

     println("Enter amount for Goods to buy in Ksh:")
     val goodsAmount = scan.nextInt()

     println("Enter the user pin : ")
     val userPin = readln()

     if(userPin == userBuyGoods.pin && goodsAmount < userBuyGoods.accountBalance){
        userBuyGoods.accountBalance -= goodsAmount
        println("You have successfully purchased Goods worth Ksh $goodsAmount. Your new account Balance is ${userBuyGoods.accountBalance}")
     }else{
        println("You have entered Invalid PIN! or your account Balance is to low to complete the transaction.")
     }
}
fun buyAirtime (userBuyAirtime : User){
     val scan = Scanner(System.`in`)

     println("Enter amount of Credit to buy in Ksh:")
     val airtimeAmount = scan.nextInt()

     println("Enter the user pin : ")
     val userPin = readln()

     if(userPin == userBuyAirtime.pin && airtimeAmount < userBuyAirtime.accountBalance){
        userBuyAirtime.accountBalance -= airtimeAmount
        println("You have successfully purchased Ksh $airtimeAmount airtime. Your new account Balance is ${userBuyAirtime.accountBalance}")
     }else{
        println("You have entered and Invalid PIN! or your Account is to low to complete the transaction.")
     }
}
fun displayMenu (){

     println("              ")
     println("Welcome to the our Mpesa system! ")

     println(" 1. Register User ")
     println(" 2. Deposit to the account ")
     println(" 3. Send Money ")
     println(" 4. Withdraw cash from the account ")
     println(" 5. Buy Goods ")
     println(" 6. Buy Airtime ")
     println(" 7. Display user details ")
     println(" 8. Exit ")
}
fun main () {

    val users = ArrayList<User>()

    do {
        displayMenu()
        val scan = Scanner(System.`in`)

        println("Select your choice (1 to 8) : ")
        val choice = scan.nextInt()

        when (choice) {
            1 -> {
                val newUser = userRegistration()
                users.addAll(newUser)
                println("You have Successfully Registered!")
            }

            2 -> {
                if (users.isNotEmpty()) {
                    for (user in users) {
                        deposit(user)
                    }
                } else {
                    println("There are no registered users!")
                }
            }

            3 -> {
                if(users.isNotEmpty()){
                    for(user in users){
                        sendMoney(user)
                    }
                }else{
                    println("There are no registered users!")
                }
            }

            4 -> {
                if(users.isNotEmpty()){
                    for(user in users){
                        withdrawCash(user)
                    }
                }else{
                    println("There are no registered users!")
                }

            }
            5 -> {
                if(users.isNotEmpty()){
                for(user in users){
                    buyGoods(user)
                }
                }else{
                println("There are no registered users!")
                }
            }

            6 -> {
                if(users.isNotEmpty()){
                    for(user in users){
                     buyAirtime(user)
                    }
                }else{
                    println("There are no registered users!")
                }
            }

            7 -> {
                if(users.isNotEmpty()){
                    println("The Details of the user are :")
                    users.forEach { user ->
                        println("Name : ${user.name}, PIN : ${user.pin}, phoneNumber : ${user.phoneNumber}, Account Balance : ${user.accountBalance}")
                    }
                }else{
                    println("There are no registered users!")
                }
            }

            8 -> {
                println("You have successfully exited the system. See you soon!")
                System.exit(0)
            }

            else -> {
                println("Invalid choice")
            }
        }

        }while (true)

}