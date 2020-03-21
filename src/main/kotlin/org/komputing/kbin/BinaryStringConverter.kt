package org.komputing.kbin

import org.komputing.kbin.model.BinaryString
import org.komputing.kbin.model.CleanBinaryString
import java.lang.IllegalArgumentException

fun BinaryString.toCleanBinaryString() = CleanBinaryString(string.replace(" ", "").let {
    if ((it.length % 8) == 0) it else "0".repeat(8 - (it.length % 8)) + it
})

fun BinaryString.binToByteArray() = toCleanBinaryString().binToByteArray()

fun CleanBinaryString.binToByteArray() = ByteArray(string.count() / 8) { i ->
    val map = string.substring(i * 8 until (i + 1) * 8).reversed().mapIndexed { k, v ->
        when (v) {
            '0' -> 0
            '1' -> 1.shl(k)
            else -> throw IllegalArgumentException("binar must consist of 0 or 1 - but found $v")
        }
    }
    map.fold(0.toByte()) { acc, current -> (acc + current).toByte() }
}
