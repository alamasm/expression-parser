package Test

import Parser.InfixParser
import Math.StandartOperationPerformer

fun main(s: Array<String>) {
    val parser = InfixParser(StandartOperationPerformer())
    //println("RESULT " + parser.calculate("√ cos ( 0 )"))
    //println("RES " + parser.calculate("3 - ( 5 + 2 )"))
    //println("RES " + parser.calculate("√ ( abs ( 5 + ( 2 ^ 4 * √ 3 * cos ( 5 * √ 9 ) ) / 2 ) )"))
    println("RES " + parser.calculate("3 * ( 5 + 10 ) / ( 3 - 1 )"))
}
