package br.com.jef.agendav4.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.jef.agendav4.databinding.ActivityResumeBinding
import br.com.jef.agendav4.utils.Constante

class ResumeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResumeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getName()
        getBack()
    }

    private fun getName() {
        val name = intent.getStringExtra(Constante.NAME_INTENT)
        val tel = intent.getStringExtra(Constante.TEL_INTENT)
        val gender = intent.getStringExtra(Constante.GENDER_INTENT)
        binding.txtNameResume.text = name
        binding.txtTelephoneResume.text = tel
        binding.txtGenderResume.text = gender
    }

    private fun getBack() {
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}