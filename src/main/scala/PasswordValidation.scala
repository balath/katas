object PasswordValidation {
  def validate(password: String): Boolean =
    password.length > 8 &&
      password.contains("_") &&
      password.exists(_.isDigit) &&
      password.exists(_.isUpper) &&
      password.exists(_.isLower)

}
