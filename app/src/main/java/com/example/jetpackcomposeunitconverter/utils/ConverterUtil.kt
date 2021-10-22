package com.example.jetpackcomposeunitconverter.utils

object ConverterUtil {

    val CONVERTER_TYPES = listOf(
        "Area",
        "Digital Storage",
        "Energy",
        "Frequency",
        "Length",
        "Speed",
        "Temperature",
        "Time",
        "Volume",
        "Weight"
    )

    private val area = mapOf(
        "Square Kilometre" to 1e-6,
        "Square Metre" to 1.0,
        "Square Mile" to 3.861e-7,
        "Square Yard" to 1.19599,
        "Square Foot" to 10.7639,
        "Square Inch" to 1550.0,
        "Hectare" to 1e-4,
        "Acre" to 0.000247,
    )

    private val digitalStorage = mapOf(
        "Bit" to 8.0,
        "Kilobit" to 0.008,
        "Megabit" to 8e-6,
        "Gigabit" to 8e-9,
        "Terabit" to 8e-12,
        "Petabit" to 8e-15,
        "Byte" to 1.0,
        "Kilobyte" to 0.001,
        "Megabyte" to 1e-6,
        "Gigabyte" to 1e-9,
        "Terabyte" to 1e-12,
        "Petabyte" to 1e-15

    )
    private val energy = mapOf(
        "Joule" to 1.0,
        "Kilojoules" to 0.001,
        "Gram Calorie" to 0.239006,
        "Kilo Calorie" to 0.000239006,
        "Watt Hour" to 0.000277778,
        "Kilowatt Hour" to 2.7778e-7,
        "Electron Volt" to 6.242e+18,
        "British Thermal Unit" to 0.000947817,
        "US Therm" to 9.4804e-9,
        "Foot-Pound" to 0.737562,
    )

    private val frequency = mapOf(
        "Hertz" to 1.0,
        "Kilohertz" to 0.001,
        "Megahertz" to 1e-6,
        "Gigahertz" to 1e-9,
    )

    private val length = mapOf(
        "Kilometre" to 0.001,
        "Metre" to 1.0,
        "Centimetre" to 100.0,
        "Millimetre" to 1000.0,
        "Micrometre" to 1e+6,
        "Nanometre" to 1e+9,
        "Mile" to 0.000621371,
        "Yard" to 1.09361,
        "Foot" to 3.28084,
        "Inch" to 0.0254
    )

    private val speed = mapOf(
        "Miles per hour" to 1.0,
        "Foot per second" to 1.4667,
        "Metre per second" to 0.44704,
        "Kilometre per hour" to 1.60934,
        "Knot" to 0.868976,
    )

    private val time = mapOf(
        "Nanosecond" to 6e+10,
        "Microsecond" to 6e+7,
        "Millisecond" to 6e+4,
        "Second" to 60.0,
        "Minute" to 1.0,
        "Hour" to 0.0167,
        "Day" to 0.000694,
        "Week" to 9.9206e-5,
        "Month" to 2.2831e-5,
        "Year" to 1.9026e-6,
        "Decade" to 1.9026e-7,
        "Century" to 1.9026e-8,
    )

    private val volume = mapOf(
        "Gallon (US)" to 0.264172,
        "quart (US)" to 1.05669,
        "Pint(US)" to 2.11228,
        "Cup (US)" to 4.16667,
        "Fluid ounce (US)" to 33.814,
        "Tablespoon (US)" to 67.628,
        "Teaspoon (US)" to 202.884,
        "Cubic metre" to 0.001,
        "Litre" to 1.0,
        "Millilitre" to 1000.0,
        "Gallon (Imp)" to 0.219969,
        "Quart (Imp)" to 0.879877,
        "Pint (Imp)" to 1.75975,
        "Cup (Imp)" to 3.51951,
        "Fluid ounce (Imp)" to 35.1951,
        "Tablespoon (Imp)" to 56.3121,
        "Teaspoon (Imp)" to 168.936,
        "Cubic foot" to 0.0353147,
        "Cubic inch" to 161.0237,
    )

    private val weight = mapOf(
        "Tonne" to 1e-6,
        "Kilogram" to 0.001,
        "Gram" to 1.0,
        "Milligram" to 1000.0,
        "Microgram" to 1e+6,
        "Imperial ton" to 9.8421e-7,
        "US ton" to 1.1023e-6,
        "Stone" to 0.000157473,
        "Pound" to 0.00220462,
        "Ounce" to 0.035274,
    )

    fun convert(
        converterType: String,
        convertFrom: String,
        convertTo: String,
        amount: Double
    ):Double{
        return when(converterType){
            "Area" -> amount * area[convertTo]!! / area[convertFrom]!!
            "Digital Storage" -> amount * digitalStorage[convertTo]!! / digitalStorage[convertFrom]!!
            "Energy" -> amount * energy[convertTo]!! / energy[convertFrom]!!
            "Frequency" -> amount * frequency[convertTo]!! / frequency[convertFrom]!!
            "Length" -> amount * length[convertTo]!! / length[convertFrom]!!
            "Speed" -> amount * speed[convertTo]!! / speed[convertFrom]!!
            "Time" -> amount * time[convertTo]!! / time[convertFrom]!!
            "Volume"-> amount * volume[convertTo]!! / volume[convertFrom]!!
            "Weight" -> amount * weight[convertTo]!! / weight[convertFrom]!!
            "Temperature" -> {
                val celsius = mapOf(
                    "Celsius" to amount * 1.0,
                    "Fahrenheit" to (amount * 9/5) + 32,
                    "Kelvin" to amount + 273.15
                )

                val fahrenheit = mapOf(
                    "Celsius" to (amount - 32) * 5/9,
                    "Fahrenheit" to amount * 1.0,
                    "Kelvin" to ((amount - 32) * 5/9) + 273.15
                )

                val kelvin = mapOf(
                    "Celsius" to amount  -273.15,
                    "Fahrenheit" to ((amount - 273.15) * 9/5) + 32,
                    "Kelvin" to amount * 1.0
                )

                when(convertFrom){
                    "Celsius" -> celsius[convertTo]!!
                    "Fahrenheit" -> fahrenheit[convertTo]!!
                    "Kelvin" -> kelvin[convertTo]!!
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun getConverterValues(
        converterType: String
    ): List<String>{
        return when(converterType){
            "Area" -> area.keys
            "Digital Storage" -> digitalStorage.keys
            "Energy" -> energy.keys
            "Frequency" -> frequency.keys
            "Length" -> length.keys
            "Speed" -> speed.keys
            "Temperature" -> setOf("Celsius", "Fahrenheit", "Kelvin")
            "Time" -> time.keys
            "Volume" -> volume.keys
            "Weight" -> weight.keys
            else -> setOf()
        }.toList()
    }
}



















