package org.komputing.kbin

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.komputing.kbin.model.BinaryString
import java.lang.IllegalArgumentException
import kotlin.test.assertFailsWith

fun String.binToByteArray() = BinaryString(this).binToByteArray()

class KBinTests {

    @Test
    fun testConvertOneByte() {

        assertThat("00000001".binToByteArray()).isEqualTo(ByteArray(1) { 1 })
        assertThat("00000010".binToByteArray()).isEqualTo(ByteArray(1) { 2 })

    }

    @Test
    fun testConvertTwoBytesByte() {
        assertThat("0000000000000001".binToByteArray()).isEqualTo(ByteArray(2) { i -> i.toByte() })
    }


    @Test
    fun testConvertWithSeparation() {
        assertThat("00000000 00000001".binToByteArray()).isEqualTo(ByteArray(2) { i -> i.toByte() })
    }

    @Test
    fun testIllegalChar() {
        assertFailsWith<IllegalArgumentException> {
            ("00000002 00000001".binToByteArray())
        }
    }

    @Test
    fun testEmpty() {
        assertThat("".binToByteArray()).isEqualTo(ByteArray(0))
    }

    @Test
    fun testShort() {
        assertThat("1".binToByteArray()).isEqualTo(ByteArray(1) { 1 })
        assertThat("11".binToByteArray()).isEqualTo(ByteArray(1) { 3 })
    }

}
