import munit.FunSuite
import PasswordValidation._

class PasswordValidationTest extends FunSuite {

  val clue = (input: String) => s"Test failed with input $input"

  test("On Iteration 1, a valid password should return true when is applied to validate function"){
    val validPasswords = List("1234_abcD", "123456_aB", "_1a_2a_3A_")
    validPasswords.map(pass => assert(validate(pass), clue(pass)))
  }

  test("On Iteration 1, a invalid password should return false when is applied to validate function"){
    val invalidPasswords = List(" ", "", "_", "1a_","123456789", "abcdefghi", "12345abcde", "1234_abcd", "123_abcD")
    invalidPasswords.map(pass => assertEquals(validate(pass), false, clue(pass)))
  }

  test("On Iteration 2, a valid password, type 2, should return true when is applied to validate function"){
    val validPasswords = List("1234abCD", "12345aB", "_1a_2a_3A_")
    validPasswords.map(pass => assert(Validation2.validate(pass), clue(pass)))
  }

  test("On Iteration 2, a invalid password, type 2, should return false when is applied to validate function"){
    val invalidPasswords = List(" ", "", "_", "1a_","123456789", "abcdefghi", "12345abcde", "1234_abcd", "123abC")
    invalidPasswords.map(pass => assertEquals(Validation2.validate(pass), false, clue(pass)))
  }

  test("On Iteration 2, a valid password, type 3, should return true when is applied to validate function"){
    val validPasswords = List("qwertyuiop_ASDFGH", "0123456789_aaaAAA", "_1a_2a_3A_1a_2a_3A_")
    validPasswords.map(pass => assert(Validation3.validate(pass), clue(pass)))
  }

  test("On Iteration 2, a invalid password, type 3, should return false when is applied to validate function"){
    val invalidPasswords = List(" ", "", "_", "1a_","123456789qwertyuiop", "abcdefghi", "12345abcde", "1234_abcd", "0123456789aaaaAAA")
    invalidPasswords.map(pass => assertEquals(Validation3.validate(pass), false, clue(pass)))
  }

}
