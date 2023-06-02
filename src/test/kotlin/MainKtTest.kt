import org.junit.Test
import kotlin.test.assertEquals
class TransferCommissionCalculatorTest {
    @Test
    fun `test VK Pay commission when transfer amount is less than VK Pay limit`() {
        val transferAmount = 1000
        val commission = calculateTransferCommission(cardType = "VK Pay", transferAmount = transferAmount)

        assertEquals(0, commission)
    }

    @Test
    fun `test VK Pay commission when transfer amount is equal to VK Pay limit`() {
        val transferAmount = 15000
        val commission = calculateTransferCommission(cardType = "VK Pay", transferAmount = transferAmount)

        assertEquals(0, commission)
    }

    @Test
    fun `test VK Pay commission when transfer amount is greater than VK Pay limit`() {
        val transferAmount = 20000
        val commission = calculateTransferCommission(cardType = "VK Pay", transferAmount = transferAmount)

        assertEquals(5, commission)
    }

    @Test
    fun `test Vk Pay monthly limit`() {
        val transferAmount = 40000
        val commission = calculateTransferCommission(cardType = "VK Pay", previousTransfersAmount = 25000, transferAmount = transferAmount)

        assertEquals(5, commission)
    }

    @Test
    fun `test Mastercard commission when transfer amount is less than MastercardMaestroLimit`() {
        val transferAmount = 400
        val commission = calculateTransferCommission(cardType = "Maestro", transferAmount = transferAmount)

        assertEquals(0, commission)
    }

    @Test
    fun `test Mastercard commission when transfer amount is equal to MastercardMaestroLimit`() {
        val transferAmount = 75000
        val commission = calculateTransferCommission(cardType = "Maestro", transferAmount = transferAmount)

        assertEquals(0, commission)
    }

    @Test
    fun `test Mastercard commission when transfer amount is greater than MastercardMaestroLimit`() {
        val transferAmount = 80000
        val commission = calculateTransferCommission(cardType = "Maestro", transferAmount = transferAmount)

        assertEquals(508, commission)
    }

    @Test
    fun `test Visa commission`() {
        val transferAmount = 1000
        val commission = calculateTransferCommission(cardType = "Visa", transferAmount = transferAmount)

        assertEquals(43, commission)
    }

    @Test
    fun `test Мир commission`() {
        val transferAmount = 1000
        val commission = calculateTransferCommission(cardType = "Мир", transferAmount = transferAmount)

        assertEquals(43, commission)
    }
}
