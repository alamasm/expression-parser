package Math

import Math.Utils.*

class StandartOperationPerformer : OperationPerformer {

    override fun performOperationWithOneOperand(operationSymbol: String, operand: Double): Double {
        if (!OperationPerformer.ONE_OPERAND_OPERATIONS.contains(operationSymbol)) throw InvalidOperandsQuantityException()

        var result = operand
        when (operationSymbol) {
            MathUtils.SQRT_SYMBOL -> result = MathUtils.sqrt(operand)
            "!" -> result = MathUtils.factorial(operand)
            "sin" -> result = MathUtils.sin(operand)
            "asin" -> result = MathUtils.asin(operand)
            "cos" -> result = MathUtils.cos(operand)
            "acos" -> result = MathUtils.acos(operand)
            "tan" -> result = MathUtils.tan(operand)
            "atan" -> result = MathUtils.atan(operand)
            "cot" -> result = MathUtils.cot(operand)
            "acot" -> result = MathUtils.acot(operand)
            "abs" -> result = MathUtils.abs(operand)
        }
        return result
    }

    override fun performOperationWithTwoOperands(operationSymbol: String, operand1: Double, operand2: Double): Double {
        if (!OperationPerformer.TWO_OPERANDS_OPERATIONS.contains(operationSymbol)) throw  InvalidOperandsQuantityException()

        var result = operand1
        when (operationSymbol) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> result = MathUtils.divide(operand1, operand2)
            "^" -> result = MathUtils.pow(operand1, operand2)
        }
        return result
    }
}