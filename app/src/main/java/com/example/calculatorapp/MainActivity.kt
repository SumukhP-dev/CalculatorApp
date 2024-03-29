package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var historyText = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number1 = findViewById<TextView>(R.id.Number1)
        var number2 = findViewById<TextView>(R.id.Number2)
        var finalNumber = findViewById<TextView>(R.id.FinalNumber)

        // Functionality for Plus button
        findViewById<Button>(R.id.PlusButton).setOnClickListener {
            if (number1.text != null && number2.text != null) {
                finalNumber.text = (number1.text.toString().toDouble()
                        + number2.text.toString().toDouble()).toString()
                historyText.add(number1.text.toString() + " + " +
                        number2.text.toString() + " = " + finalNumber.text.toString() + "\n")
            }
        }

        // Functionality for Minus button
        findViewById<Button>(R.id.MinusButton).setOnClickListener {
            if (number1.text != null && number2.text != null) {
                finalNumber.text = (number1.text.toString().toDouble()
                        - number2.text.toString().toDouble()).toString()
                historyText.add(number1.text.toString() + " - " +
                        number2.text.toString() + " = " + finalNumber.text.toString() + "\n")
            }
        }

        // Functionality for Multiplication button
        findViewById<Button>(R.id.MultiplicationButton).setOnClickListener {
            if (number1.text != null && number2.text != null) {
                finalNumber.text = (number1.text.toString().toDouble()
                        * number2.text.toString().toDouble()).toString()
                historyText.add(number1.text.toString() + " * " +
                        number2.text.toString() + " = " + finalNumber.text.toString() + "\n")
            }
        }

        // Functionality for Division button
        findViewById<Button>(R.id.DivisionButton).setOnClickListener {
            if (number1.text != null && number2.text != null) {
                finalNumber.text = (number1.text.toString().toDouble()
                        / number2.text.toString().toDouble()).toString()
                historyText.add(number1.text.toString() + " / " +
                        number2.text.toString() + " = " + finalNumber.text.toString() + "\n")
            }
        }

        // Functionality for History button
        findViewById<Button>(R.id.History).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putStringArrayListExtra("historyText", historyText)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
