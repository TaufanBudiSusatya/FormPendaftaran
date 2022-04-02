package com.example.taufanbudisusatya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mendeklarasikan variabel kirim dari button submit
        val kirim = findViewById<Button>(R.id.submit)
        //membuat perintah ketika di klik akan mengirim pesan
        //dan berisi function sendMessage()
        kirim.setOnClickListener{
            sendMessage()
        }
    }

    private fun sendMessage(){
        // mendeklrasikan variable dari widget di xml
        val tx_msg = findViewById<EditText>(R.id.et_nama)
        val telpon = findViewById<EditText>(R.id.et_telepon)
        val al = findViewById<EditText>(R.id.et_alamat)
        val em = findViewById<EditText>(R.id.et_email)


        // merubah variable diatas menjadi string
        val tel = telpon.text.toString()
        val message = tx_msg.text.toString()
        val alamat = al.text.toString()
        val email = em.text.toString()


        //perintah intent untuk berpindah ke activity kedua
        val intent = Intent(this,TaufanIntentActivity::class.java)
        //memberikan pesan yang akan di kirim
        intent.apply {
            putExtra("theMessage",message)
            putExtra("telpon",tel)
            putExtra("alamat",alamat)
            putExtra("email",email)

        }
        //memulai activity
        startActivity(intent)
    }
}