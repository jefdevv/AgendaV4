package br.com.jef.agendav4.ui

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jef.agendav4.R
import br.com.jef.agendav4.databinding.ActivityMainBinding
import br.com.jef.agendav4.utils.Constante
import br.com.jef.agendav4.utils.listener.AgendaListener


class MainActivity : AppCompatActivity(), AgendaListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sendName()
    }

    private fun initRecycler(
        listName: MutableList<String>,
        listNumber: MutableList<String>,
        listGender: MutableList<String>
    ) {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.adapter = Adapter(listName, listNumber, listGender, this)
    }

    private fun sendName() {
        val listName = mutableListOf<String>()
        val listNumber = mutableListOf<String>()
        val listGender = mutableListOf<String>()
        binding.btnSave.setOnClickListener {
            val edtName = binding.edtName.text
            val edtNumber = binding.edtPhone.text
            if (binding.edtName.text.isEmpty()) {
                binding.edtName.error = getString(R.string.campo_vazio)

            } else if (binding.edtPhone.text.isEmpty()) {
                binding.edtPhone.error = getString(R.string.campo_vazio)
            } else {
                listName.add(edtName.toString())
                listNumber.add(edtNumber.toString())
                listGender.add(getGender())
                initRecycler(listName, listNumber, listGender)
                clearFields()


            }

        }
    }

    private fun clearFields() {
        binding.edtName.text.clear()
        binding.edtPhone.text.clear()
        binding.radioGroup.check(-1)
        binding.edtName.requestFocus()


    }

    private fun getGender(): String {
        val rdGroup = binding.radioGroup
        val id: Int = rdGroup.checkedRadioButtonId
        if (id == -1) {


        } else {
            val btn = findViewById<RadioButton>(id)
            return btn.text.toString()

        }
        return ""

    }

    override fun onClick(name: String, tel: String, gender: String) {
        val intent = Intent(this, ResumeActivity::class.java)
        intent.putExtra(Constante.NAME_INTENT, name)
        intent.putExtra(Constante.TEL_INTENT, tel)
        intent.putExtra(Constante.GENDER_INTENT, gender)

        startActivity(intent)
    }


}