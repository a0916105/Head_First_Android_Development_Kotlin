package tw.idv.jew.starbuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.findNavController

class SelectCoffeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_coffee, container, false)
        val nextButton = view.findViewById<Button>(R.id.next)
        nextButton.setOnClickListener {
            val choice = view.findViewById<Spinner>(R.id.choose).selectedItem.toString()

            val action = SelectCoffeeFragmentDirections
                .actionSelectCoffeeFragmentToCoffeeFragment(choice)
            view.findNavController().navigate(action)
        }
        return view
    }
}