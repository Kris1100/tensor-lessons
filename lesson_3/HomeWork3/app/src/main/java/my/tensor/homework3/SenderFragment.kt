package my.tensor.homework3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.google.android.material.textfield.TextInputEditText


class SenderFragment : Fragment(){
    private lateinit var message: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.send_button).setOnClickListener(){

            val ReceiverFragment = ReceiverFragment.newInstance(
                view.findViewById<TextInputEditText>(R.id.textEdit).getText().toString())
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ReceiverFragment)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sender_fragment, container, false)
    }
    private fun addReceiverFragment(){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ReceiverFragment())
            .commit()
    }
}