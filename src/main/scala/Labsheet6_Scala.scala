import scala.io.StdIn._

object Labsheet6_Scala {
  def main(args : Array[String]) : Unit = {

    print("The Shift Value : ");
    val value = readInt();

    print("String to ecnrypt : ");
    val str = readLine();

    if(value > 0 || value < 26) {
      cipher(str, value);
    } else {
      println("Invalid Input!");
    }
  }

  def Encryption(character : Char, value : Int) : Char = {
    if(character.isLower) {
      return ((character - 'a' + (26 - value)) % 26 + 'a').toChar
    } else {
      return ((character - 'A' + (26 - value)) % 26 + 'A').toChar
    }
  }

  def Decryption(character : Char, value : Int) : Char = {
    if(character.isLower) {
      return ((character - 'a' + value) % 26 + 'a').toChar
    } else {
      return ((character - 'A' + value) % 26 + 'A').toChar
    }
  }

  def cipher(str : String, value : Int) : Unit = {
    var encrypted = str.map(character => if(character.isLetter) Encryption(character, value) else character)
    println("Encrypted text : " + encrypted);
    var decrypted=encrypted.map(character => if(character.isLetter) Decryption(character, value) else character)
    println("Decrypted text : " + decrypted);
  }
}