package tw.idv.jew.crossword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import tw.idv.jew.crossword.databinding.FragmentCrosswordBinding

class CrosswordFragment : Fragment() {
    private var _binding: FragmentCrosswordBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: CrosswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCrosswordBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(CrosswordViewModel::class.java)

        binding.vm = viewModel   //將viewModel指派給gameViewModel的data binding
        //更新畫面
        binding.lifecycleOwner = viewLifecycleOwner //讓每一個view直接回應live data的改變（不需使用observe()來寫程式碼更新）
        return view
    }
}