package com.lokalise.kotlini18n

import android.content.Context
import android.os.Bundle
import android.os.LocaleList
import android.text.BidiFormatter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.DateFormat.SHORT
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale()
        setContentView(R.layout.activity_main)

        val welcomeTextView: TextView = findViewById(R.id.textViewWelcome) // 1
        val changeLangButton: Button = findViewById(R.id.buttonChangeLang) // 2

        welcomeTextView.setText(R.string.welcome) // 3
        changeLangButton.setText(R.string.change_lang) // 4

        changeLangButton.setOnClickListener {
            val languages = arrayOf("عربى", "français", "English")

            val langSelectorBuilder = AlertDialog.Builder(this@MainActivity)
            langSelectorBuilder.setTitle("Choose language:")
            langSelectorBuilder.setSingleChoiceItems(languages, -1) { dialog, selection ->
                when(selection) {
                    0 -> {
                        setLocale("ar")
                    }
                    1 -> {
                        setLocale("fr")
                    }
                    2 -> {
                        setLocale("en")
                    }
                }
                recreate()
                dialog.dismiss()
            }
            langSelectorBuilder.create().show()
        }

//        numFormat()
//        textFormat()
//        pluralization()
//        dateAndTime()
    }

    private fun loadLocale() {
        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val localeToSet: String = sharedPref.getString("locale_to_set", "")!!
        setLocale(localeToSet)
    }

    private fun setLocale(localeToSet: String) {
        val localeListToSet = LocaleList(Locale(localeToSet))
        LocaleList.setDefault(localeListToSet)

        resources.configuration.setLocales(localeListToSet)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)

        val sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        sharedPref.putString("locale_to_set", localeToSet)
        sharedPref.apply()
    }

    fun numFormat() {
        val num = 1516.22 // 1
        val numAsString = String.format("%f", num) // 2

        val welcomeTextView: TextView = findViewById(R.id.textViewWelcome)
        welcomeTextView.text = numAsString // 3
    }

    fun textFormat() {
        val address = "1 Apple Park Way, Cupertino, CA" // 1
        val bidiFormatter: BidiFormatter = BidiFormatter.getInstance()

        val unicodeWrappedAddress = bidiFormatter.unicodeWrap(address) // 2
        val formatStr = getString(R.string.located_at) // 3
        val locatedAtQuestionStr = String.format(formatStr, unicodeWrappedAddress) // 4

        val addressTextView: TextView = findViewById(R.id.textViewAddress)
        addressTextView.text = locatedAtQuestionStr // 5
    }

    fun pluralization() {
        val pluralViewOne: TextView = findViewById(R.id.pluralViewOne)
        val quantityStringFor1: String = resources.getQuantityString(
            R.plurals.patients_reported,
            1,
            1
        )
        pluralViewOne.text = quantityStringFor1

        val pluralViewFew: TextView = findViewById(R.id.pluralViewFew)
        val quantityStringFor2: String = resources.getQuantityString(
            R.plurals.patients_reported,
            2,
            2
        )
        pluralViewFew.text = quantityStringFor2

        val pluralViewMany: TextView = findViewById(R.id.pluralViewMany)
        val quantityStringFor5: String = resources.getQuantityString(
            R.plurals.patients_reported,
            5,
            5
        )
        pluralViewMany.text = quantityStringFor5
    }

        fun dateAndTime() {
            val currentDateTime = Date() // 1
            val currentLocale = Locale.getDefault() // 2
            val dateTimeInstance = DateFormat.getDateTimeInstance(SHORT, SHORT, currentLocale) // 3

            val dateTimeTextView: TextView = findViewById(R.id.textViewDateTime)
            dateTimeTextView.text = dateTimeInstance.format(currentDateTime) // 4
        }
}