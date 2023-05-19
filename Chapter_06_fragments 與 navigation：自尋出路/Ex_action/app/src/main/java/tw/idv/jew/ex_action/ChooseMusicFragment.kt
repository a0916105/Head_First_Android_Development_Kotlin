package tw.idv.jew.ex_action

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class ChooseMusicFragment : Fragment() {

    lateinit var tv_search: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_music, container, false)
        tv_search = view.findViewById<TextView>(R.id.editText)
        val searchButton = view.findViewById<Button>(R.id.search)
        searchButton.setOnClickListener { 
            if (musicFound()) {
                view.findNavController()
                    .navigate(R.id.action_chooseMusicFragment_to_foundFragment)
            } else {
                view.findNavController()
                    .navigate(R.id.action_chooseMusicFragment_to_notFoundFragment)
            }
        }
        return view
    }

    private fun musicFound(): Boolean {
        return tv_search.text.toString() == "true"
    }
}