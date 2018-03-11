package Math.Utils

class MathException(s: String) : Exception(s) {
    companion object {
        val TAN_NOT_EXISTS_TEXT = "Tan function is not determined for this argument"
        val COT_NOT_EXISTS_TEXT = "Cot function is not determined for this argument"
        val NOT_INTEGER_FACTORIAL_TEXT = "Factorial function can be applied only to integers"
        val NEATIVE_SQRT_TEXT = "SQRT operand must be not negative"
        val DIVISION_BY_ZERO_TEXT = "Division by zero"
        val INCORRECT_ASIN_ARGUMENT = "Arcsin function determined only for arguments that between -1 and 1"
        val INCORRECT_ACOS_ARGUMENT = "Arccos function determined only for arguments that between -1 and 1"
    }
}