package com.dicoding.savemoney.ui.main

import android.annotation.*
import android.content.*
import android.os.*
import android.view.*
import android.widget.*
import androidx.appcompat.app.*
import androidx.navigation.*
import androidx.navigation.ui.*
import com.dicoding.savemoney.R
import com.dicoding.savemoney.ui.add.*
import com.dicoding.savemoney.ui.setting.*
import com.dicoding.savemoney.utils.*
import com.google.android.material.bottomnavigation.*
import com.google.android.material.floatingactionbutton.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_dashboard,
            R.id.navigation_transaction,
            R.id.navigation_transaction,
            R.id.navigation_profile_company,
            R.id.navigation_other
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        val fab = findViewById<FloatingActionButton>(R.id.fab)
//        fab.setOnClickListener {
//            val intent = Intent(this@MainActivity, AddExpenseActivity::class.java)
//            startActivity(intent)
//        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = when (destination.id) {
                R.id.navigation_dashboard -> "Dashboard"
                R.id.navigation_transaction -> "Transaction"
                R.id.navigation_profile_company -> "Data Company BEI"
                R.id.navigation_other -> "Portal Investasi OJK"
                else -> "Save Money"
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_dashboard_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_notification -> {
                Toast.makeText(this, "Notification Menu Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_profile -> {
                Toast.makeText(this, "Profile Menu Clicked", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.setting -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
