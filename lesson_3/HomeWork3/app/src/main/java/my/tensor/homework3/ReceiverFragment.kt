package my.tensor.homework3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ReceiverFragment : Fragment() {

    private var message: String? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", message)
    }

    companion object {
        private const val MESSAGE = "MESSAGE"
        fun newInstance(text: String): Fragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putString(MESSAGE, text)
                arguments = bundle
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null) {
            message = savedInstanceState.getString("text", "")
            view.findViewById<TextView>(R.id.textView3).setText(message)
        }else {
            message = arguments?.getString(
                MESSAGE,
                "All messages is read"
            )
        }
        view.findViewById<TextView>(R.id.textView3).setText(message)
        view.findViewById<Button>(R.id.button2).setOnClickListener() {
            message = "All messages is read"
            view.findViewById<TextView>(R.id.textView3).setText("All messages is read")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null){
            message = savedInstanceState.getString("text")
        }
        return inflater.inflate(R.layout.receiver_fragment, container, false)
    }
}