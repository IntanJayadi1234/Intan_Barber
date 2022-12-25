package org.intan.barbershop.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.intan.barbershop.R
import org.intan.barbershop.databinding.ActivityMenuBinding
import org.intan.barbershop.ui.HomeActivity
import org.intan.barbershop.ui.add.TambahTransaksiActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)
        supportActionBar?.hide()

        // click listener
        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, TambahTransaksiActivity::class.java))
        }
    }
}
