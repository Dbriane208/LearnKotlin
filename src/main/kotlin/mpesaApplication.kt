import java.util.*
data class User (
 val name : String,
 val PIN : Int,
 val phoneNumber : Int,
 var accountBalance : Double
)

fun userRegistration (): ArrayList<User>{
 val scan = Scanner(System.`in`)

 val users = ArrayList<User>()

 println("Enter your name : ")
 val userName = scan.nextLine()

 println("Set your Pin : ")
 val userPin = scan.nextInt()

 println("Enter your Phone number : ")
 val userPhoneNo = scan.nextInt()

 println("Enter your account Balance : ")
 val accountBal = scan.nextDouble()

 val userRegObject = User(userName,userPin,userPhoneNo,accountBal)
 users.add(userRegObject)

 return users
}
fun deposit (userDeposit : User){
 val scan = Scanner(System.`in`)

 println("Enter the amount to deposit : ")
 val deposit = scan.nextDouble()

 println("Enter the user pin : ")
 val userPin = scan.nextInt()

if(userPin == userDeposit.PIN){
 userDeposit.accountBalance += deposit
 println("You have deposited $deposit . Your new account Balance is ${userDeposit.accountBalance}")
}else{
 println("The PIN entered is INVALID!. Deposit failed.")
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


}