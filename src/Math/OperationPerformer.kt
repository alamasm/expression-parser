package Math

import Math.Utils.*

interface OperationPerformer {
    companion object {
        val ONE_OPERAND_OPERATIONS = listOf(MathUtils.SQRT_SYMBOL, "!", "sin", "cos", "tan", "cot", "asin", "acos", "atan",
                "acot", "abs")
        val TWO_OPERANDS_OPERATIONS = listOf("+", "-", "*", "/", "^")
        val OPERATIONS = ONE_OPERAND_OPERATIONS + TWO_OPERANDS_OPERATIONS

        val LOWEST_PRIORITY = 0
        val LOW_PRIORITY = 1
        val MID_PRIORITY = 2
        val HIGH_PRIORITY = 3
        val PRIORITIES = mapOf("+" to LOW_PRIORITY, "-" to LOW_PRIORITY, "*" to MID_PRIORITY, "/" to MID_PRIORITY,
                "^" to HIGH_PRIORITY, "!" to HIGH_PRIORITY, "(" to LOWEST_PRIORITY, ")" to LOWEST_PRIORITY,
                "sin" to HIGH_PRIORITY, "cos" to HIGH_PRIORITY, "tan" to HIGH_PRIORITY, "cot" to HIGH_PRIORITY,
                "asin" to HIGH_PRIORITY, "acos" to HIGH_PRIORITY, "atan" to HIGH_PRIORITY, "acot" to HIGH_PRIORITY,
                MathUtils.SQRT_SYMBOL to HIGH_PRIORITY, "abs" to HIGH_PRIORITY)
    }

    fun performOperationWithOneOperand(operationSymbol: String, operand: Double): Double
    fun performOperationWithTwoOperands(operationSymbol: String, operand1: Double, operand2: Double): Double
}