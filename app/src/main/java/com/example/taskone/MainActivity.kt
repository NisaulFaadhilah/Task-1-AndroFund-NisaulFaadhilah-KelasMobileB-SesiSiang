package com.example.taskone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username =intent.getParcelableExtra<User>("user")?.username
        val password =intent.getParcelableExtra<User>("user")?.password
        tv.text = "username: $username dan password: $password"

        val btnImplicit: Button =findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)

        val btnFragment: Button =findViewById(R.id.btn_fragment)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_implicit-> {
   //             val message = "Haii,, Kamu Pasti Bisa!"
   //             val intent = Intent()
   //             intent.action = Intent.ACTION_SEND
   //             intent.putExtra(Intent.EXTRA_TEXT, message)
   //             intent.type = "text/plain"
   //             startActivity(intent)
             val intent = Intent()
             intent.putExtra("history", "Anda Sudah Login")
             setResult(RESULT_OK, intent)
             finish()
            }
            R.id.btn_fragment-> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}