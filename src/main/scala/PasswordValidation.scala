object PasswordValidation {
  //Method for Iteration 1
  def validate(password: String): Boolean =
    password.length > 8 &&
      password.contains("_") &&
      password.exists(_.isDigit) &&
      password.exists(_.isUpper) &&
      password.exists(_.isLower)

  //Abstraction for Iteration 2
  sealed abstract class Validations(length: Int, capital: Boolean, lowercase: Boolean, number: Boolean, underscore: Boolean) {
    def apply(password: String): Boolean =
      (password.length > length) &&
        (if (underscore) password.contains("_") else true) &&
        (if (number) password.exists(_.isDigit) else true) &&
        (if (capital) password.exists(_.isUpper) else true) &&
        (if (lowercase) password.exists(_.isLower) else true)
  }
  final case object Validation2 extends Validations(6, capital = true, lowercase = true, number = true, underscore = false)
  final case object Validation3 extends Validations(16, capital = true, lowercase = true, number = false, underscore = true)
}
