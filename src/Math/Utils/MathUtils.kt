package Math.Utils

class MathUtils {
    companion object {
        private const val EPS = 1e-16

        val PI_SYMBOL = "π"
        val SQRT_SYMBOL = "√"

        private val CONSTANTS_SYMBOLS = listOf("e", PI_SYMBOL)
        private val CONSTANT_VALUES = mapOf("e" to Math.E, PI_SYMBOL to Math.PI)

        fun factorial(n: Double): Double {
            if (n - n.toInt().toDouble() != 0.0) throw MathException(MathException.NOT_INTEGER_FACTORIAL_TEXT)

            var result = 2.0
            for (i in 3..n.toInt()) result *= i
            return result
        }

        fun sqrt(n: Double): Double {
            if (n < 0) throw MathException(MathException.NEATIVE_SQRT_TEXT)
            else return Math.sqrt(n)
        }

        fun sin(n: Double): Double {
            return Math.sin(n)
        }

        fun asin(n: Double): Double {
            if (Math.abs(n) > 1) throw MathException(MathException.INCORRECT_ASIN_ARGUMENT)
            else return Math.asin(n)
        }

        fun cos(n: Double): Double {
            return Math.cos(n)
        }

        fun acos(n: Double): Double {
            if (Math.abs(n) > 1) throw MathException(MathException.INCORRECT_ACOS_ARGUMENT)
            else return Math.acos(n)
        }

        fun tan(n: Double): Double {
            val cos = Math.cos(n)
            if (isZero(cos)) throw MathException(MathException.TAN_NOT_EXISTS_TEXT)
            else return Math.tan(n)
        }

        fun atan(n: Double): Double {
            return Math.atan(n)
        }

        fun cot(n: Double): Double {
            val tan = tan(n)
            if (isZero(tan)) throw MathException(MathException.COT_NOT_EXISTS_TEXT)
            else return 1.0 / tan
        }

        fun acot(n: Double): Double {
            return Math.PI / 2.0 - Math.atan(n)
        }

        fun divide(a: Double, b: Double): Double {
            if (isZero(b)) throw MathException(MathException.DIVISION_BY_ZERO_TEXT)
            else return a / b
        }

        fun pow(a: Double, b: Double): Double {
            return Math.pow(a, b)
        }

        fun abs(n: Double): Double {
            return Math.abs(n)
        }

        fun isNumber(s: String): Boolean {
            if (CONSTANTS_SYMBOLS.contains(s)) return true
            if (s.toDoubleOrNull() == null) return false
            return true
        }

        fun toNumber(s: String): Double {
            return if (CONSTANT_VALUES.containsKey(s)) CONSTANT_VALUES[s]!!
            else s.toDouble()
        }

        private fun isZero(n: Double): Boolean {
            return Math.abs(n) < EPS
        }
    }
}