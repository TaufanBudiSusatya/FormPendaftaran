package com.example.taufanbudisusatya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.TextView

class TaufanIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taufan_intent)

        //menerima pesan dari activty sebelumnya
        val message = intent.getStringExtra("theMessage")
        val telepon = intent.getStringExtra("telpon")
        val alamat = intent.getStringExtra("alamat")
        val email = intent.getStringExtra("email")


        //mendaklarasikan dari button id btn_wa
        val wa = findViewById<Button>(R.id.btn_wa)
        //memberikan perintah ketika button btn_wa di klikk
        //dan berisikan function whatsapp
        wa.setOnClickListener {
        whatsapp()
    }
        //mendekralasikan dari widget xml
        val tx_msg = findViewById<TextView>(R.id.tv_nama)
        val tel = findViewById<TextView>(R.id.tv_telepon)
        val al = findViewById<TextView>(R.id.tv_alamat)
        val em = findViewById<TextView>(R.id.tv_email)


        //menampilkan di text view yang sudah di deklrasikan diatas
        tx_msg.apply {
            text = message
        }
        tel.apply {
            text = telepon
        }
        al.apply {
            text = alamat
        }
        em.apply {
            text = email
        }


        //memberi nama pada bagian action bar
        // dan membuat tombol kembali ke activity sebelumnya
        val actionbar = supportActionBar
        actionbar!!.title="Data Peserta"

        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    //membuat function untuk btn_wa agar terkoneksi ke wa
    fun whatsapp(){
        val intent = Intent(Intent.ACTION_VIEW)
        val url = "https://api.whatsapp.com/send?phone=6289525781184"

        intent.type = "text/plain"

        intent.setPackage("com.whatsapp")
        intent.setData(Uri.parse(url))

        startActivity(intent)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


