package Math

class InvalidOperandsQuantityException : Exception(TEXT) {
    companion object {
        const val TEXT = "This operation needs another operands quantity"
    }
}