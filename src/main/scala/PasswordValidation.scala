object PasswordValidation {
  def validate(password: String): Boolean =
    password.length > 8 &&
      password.contains("_") &&
      password.exists(_.isDigit) &&
      password.exists(_.isUpper) &&
      password.exists(_.isLower)

  sealed abstract class Validations(length: Int, capital: Boolean, lowercase: Boolean, number: Boolean, underscore: Boolean) {
    def validate(password: String): Boolean =
      password.length > 8 &&
        password.contains("_") &&
        password.exists(_.isDigit) &&
        password.exists(_.isUpper) &&
        password.exists(_.isLower)
  }

  final case object Validation2 extends Validations(6, true, true, true, false)
  final case object Validation3 extends Validations(16, true, true, false, true)


}
