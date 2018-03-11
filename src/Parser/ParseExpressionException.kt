package Parser

class ParseExpressionException(s: String) : Exception(s) {
    companion object {
        val SYMBOL_NOT_NUMBER_AND_NOT_OPERAND_TEXT = "One of symbols doesn't looks like number or operation"
        val INCORRECT_EXPRESSION_TEXT = "Incorrect expression"
    }
}
