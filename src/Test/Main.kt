package Test

import Parser.PostfixParser
import Math.Utils.*
import Math.StandartOperationPerformer

fun main(s: Array<String>) {
    val parser = PostfixParser(StandartOperationPerformer())
    //println("RESULT " + parser.calculate("√ cos ( 0 )"))
    //println("RES " + parser.calculate("3 - ( 5 + 2 )"))
    //println("RES " + parser.calculate("√ ( abs ( 5 + ( 2 ^ 4 * √ 3 * cos ( 5 * √ 9 ) ) / 2 ) )"))
    println("RES " + parser.calculate("3 * ( 5 + 10 ) / ( 3 - 1 )"))
}
