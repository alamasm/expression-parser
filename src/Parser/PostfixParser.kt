package Parser

import Math.*
import java.util.*
import Math.Utils.*

class PostfixParser(private val operationPerformer: OperationPerformer) : Parser {


    override fun calculate(expression: String): Double {
        val postfix = convertToPostfix(expression)
        println(postfix)
        return calculatePostfix(postfix)
    }

    private fun convertToPostfix(infixExpression: String): String {
        val equationSymbols = infixExpression.split(" ")
        val operationsStack = Stack<String>()
        var postfixString = ""

        for (symbol in equationSymbols) {
            if (symbol == "(") {
                operationsStack.push(symbol)
            } else if (symbol == ")") {
                var lastOperation = operationsStack.pop()
                while (lastOperation != "(" && !operationsStack.isEmpty()) {
                    postfixString += "$lastOperation "
                    lastOperation = operationsStack.pop()
                }
            } else if (OperationPerformer.OPERATIONS.contains(symbol)) {
                while (!operationsStack.isEmpty() && OperationPerformer.PRIORITIES[symbol]!! < OperationPerformer.PRIORITIES[operationsStack.peek()]!!)  //TODO
                    postfixString += "${operationsStack.pop()} "
                operationsStack.push(symbol)
            } else {
                println(symbol)
                if (!MathUtils.isNumber(symbol)) throw  ParseExpressionException(ParseExpressionException.SYMBOL_NOT_NUMBER_AND_NOT_OPERAND_TEXT)
                else postfixString += "${MathUtils.toNumber(symbol)} "
            }
        }

        while (!operationsStack.isEmpty()) {
            if (!OperationPerformer.OPERATIONS.contains(operationsStack.peek())) throw ParseExpressionException(ParseExpressionException.INCORRECT_EXPRESSION_TEXT)
            postfixString += "${operationsStack.pop()} "
        }
        return postfixString.substring(0, postfixString.length - 1)
    }

    private fun calculatePostfix(postfixExpression: String): Double {
        val stack = Stack<Double>()
        for (symbol in postfixExpression.split(" ")) {

            if (OperationPerformer.ONE_OPERAND_OPERATIONS.contains(symbol)) {
                stack.push(operationPerformer.performOperationWithOneOperand(symbol, stack.pop()))
            } else if (OperationPerformer.TWO_OPERANDS_OPERATIONS.contains(symbol)) {
                val operand2 = stack.pop();
                val operand1 = stack.pop()
                stack.push(operationPerformer.performOperationWithTwoOperands(symbol, operand1, operand2))
            } else {
                if (!MathUtils.isNumber(symbol)) throw ParseExpressionException(ParseExpressionException.INCORRECT_EXPRESSION_TEXT)
                else stack.push(MathUtils.toNumber(symbol))
            }
        }

        if (stack.isEmpty()) throw ParseExpressionException(ParseExpressionException.INCORRECT_EXPRESSION_TEXT)
        else return stack.pop()
    }
}
