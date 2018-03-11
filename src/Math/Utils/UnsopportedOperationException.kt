package Math.Utils

class UnsopportedOperationException(symbol: String): Exception(TEXT + symbol) {
    companion object {
        private const val TEXT = "We don't know about that operation: "
    }
}