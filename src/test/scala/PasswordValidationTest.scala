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
}
