package tw.idv.jew.lifecycleexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv_x: TextView
    var temp_tv_text: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temp_tv_text = savedInstanceState?.getString("temp_tv_text") ?: ""

        tv_x = findViewById<TextView>(R.id.tv_x)
        tv_x.text = "${temp_tv_text}\nA"
        temp_tv_text = tv_x.text.toString()
        Log.d("life", temp_tv_text)
    }

    override fun onPause() {
        super.onPause()

        temp_tv_text = "${temp_tv_text}\nB"
        Log.d("life", temp_tv_text)
    }

    override fun onRestart() {
        super.onRestart()

        temp_tv_text = "${temp_tv_text}\nC"
        Log.d("life", temp_tv_text)
    }

    override fun onResume() {
        super.onResume()

        temp_tv_text = "${temp_tv_text}\nD"
        tv_x.text = temp_tv_text
        Log.d("life", temp_tv_text)
    }

    override fun onStop() {
        super.onStop()

        temp_tv_text = "${temp_tv_text}\nE"
        Log.d("life", temp_tv_text)
    }

    fun onRecreate() {  //沒有此生命週期方法
        temp_tv_text = "${temp_tv_text}\nF"
        Log.d("life", temp_tv_text)
    }

    override fun onStart() {
        super.onStart()

        tv_x.text = "${temp_tv_text}\nG"
        temp_tv_text = tv_x.text.toString()
        Log.d("life", temp_tv_text)
    }

    override fun onDestroy() {
        super.onDestroy()
        //onSaveInstanceState()比onDestroy()還早執行，所以無法利用onSaveInstanceState()來儲存"H"
        temp_tv_text = "${temp_tv_text}\nH"
        Log.d("life", temp_tv_text) //"H"只會出現在此Log
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {

        savedInstanceState.putString("temp_tv_text", temp_tv_text)

        super.onSaveInstanceState(savedInstanceState)
    }
}