fun calculateTransferCommission(cardType: String = "VK Pay", previousTransfersAmount: Int = 0, transferAmount: Int): Int {
    val vkPayLimit = 15000
    val vkPayMonthlyLimit = 40000
    val mastercardMaestroMinAmount = 300
    val mastercardMaestroMaxAmount = 75000
    var commission = 0

    if (cardType == "VK Pay") {
        if (transferAmount <= vkPayLimit && previousTransfersAmount + transferAmount <= vkPayMonthlyLimit) {
            commission = 0
        } else {
            commission = 5 // assuming fixed commission of 5 rubles for VK Pay transfers exceeding limits
        }
    } else if (cardType == "Mastercard" || cardType == "Maestro") {
        if (transferAmount >= mastercardMaestroMinAmount && transferAmount <= mastercardMaestroMaxAmount) {
            commission = 0
        } else {
            commission = ((0.6 / 100) * transferAmount + 20).toInt() // assuming commission is calculated with a rounding down
        }
    } else if (cardType == "Visa" || cardType == "Мир") {
        commission = ((0.75 / 100) * transferAmount + 35).toInt() // assuming commission is calculated with a rounding down
    }

    return commission
}
