fun main() {
    println("был(а) ${agoToText(3601)}")
}

fun agoToTextException(currentTimeOfAbsence: Int): String {
    val secInHour = 60 * 60
    val secInDay = secInHour * 24

    return when (currentTimeOfAbsence) {
        in 61..secInHour -> {
            val timeInMinutes = currentTimeOfAbsence / 60
            if (timeInMinutes % 10 == 1) {
                "в сети $timeInMinutes минуту назад"
            } else if (timeInMinutes % 10 == 2 || timeInMinutes % 10 == 3 || timeInMinutes % 10 == 4) {
                "в сети $timeInMinutes минуты назад"
            } else
                "в сети $timeInMinutes минут назад"
        }

        in secInHour + 1..secInDay -> {
            val timeInHours = currentTimeOfAbsence / secInHour
            if (timeInHours % 10 == 1) {
                "в сети $timeInHours час назад"
            } else if (timeInHours % 10 == 2 || timeInHours % 10 == 3 || timeInHours % 10 == 4) {
                "в сети $timeInHours часа назад"
            } else
                "в сети $timeInHours часов назад"
        }

        else -> {
            "Ошибка"
        }
    }
}

fun agoToText(currentTimeOfAbsence: Int): String {
    val secInHour = 60 * 60
    val secInDay = secInHour * 24

    return when (currentTimeOfAbsence) {
        in 0..60 -> "только что"
        in 61..secInHour, in secInHour + 1..secInDay -> agoToTextException(currentTimeOfAbsence)
        in secInDay + 1..secInDay * 2 -> "вчера"
        in secInDay * 2 + 1..secInDay * 3 -> "позавчера"
        else -> "давно"
    }

}

