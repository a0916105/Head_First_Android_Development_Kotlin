package tw.idv.jew.drinksapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_title, container, false)
        val startButton = view.findViewById<Button>(R.id.start)

        startButton.setOnClickListener {
            view.findNavController()    //取得導覽控制器
                .navigate(R.id.action_titleFragment_to_chooseTypeFragment)   //巡覽至MessageFragment（使用action ID）
        }
        return view
    }
}