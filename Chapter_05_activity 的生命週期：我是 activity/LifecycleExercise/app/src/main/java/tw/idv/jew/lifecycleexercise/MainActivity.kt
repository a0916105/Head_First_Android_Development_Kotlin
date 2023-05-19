package tw.idv.jew.lifecycleexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var x = 0

    lateinit var tv_x:TextView
    var temp_tv_text:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        x = savedInstanceState?.getInt("x") ?: 2

        temp_tv_text = savedInstanceState?.getString("temp_tv_text") ?: ""

        tv_x = findViewById<TextView>(R.id.tv_x)
        tv_x.text = "${temp_tv_text}\nonCreate的x = $x"
        temp_tv_text = tv_x.text.toString()
    }

    override fun onRestart() {  //畫面旋轉會銷毀Activity，不會呼叫onRestart()
        super.onRestart()
        x -= 7

        temp_tv_text = "${temp_tv_text}\nonRestart的x = $x"
    }

    override fun onStart() {
        super.onStart()
        x += 6

        tv_x.text = "${temp_tv_text}\nonStart的x = $x"   //跳到主畫面，再回到APP，執行onRestart()，但不會再次執行onCreate()
        temp_tv_text = tv_x.text.toString()
    }

    override fun onStop() {
        super.onStop()
        x *= 2

        temp_tv_text = "${temp_tv_text}\nonStop的x = $x"
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("x", x + 1)   //只是把值存入對應key，但目前x值不變

        temp_tv_text = "${temp_tv_text}\nsavedInstanceState的x = $x"
        savedInstanceState.putString("temp_tv_text", temp_tv_text)

        super.onSaveInstanceState(savedInstanceState)
    }
}