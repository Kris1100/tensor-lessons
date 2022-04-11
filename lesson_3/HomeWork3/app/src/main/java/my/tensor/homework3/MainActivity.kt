package my.tensor.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModel : ViewModel(){
    private val messageMutableLiveData = MutableLiveData("All messages is read")
    val messageLiveData : LiveData<String>
        get() = messageMutableLiveData
    fun inputMessage(str: String){
        messageMutableLiveData.value = str
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addSenderFragment()
        }
    }
    override fun onBackPressed() {
        replaceSenderFragment()
    }

    private fun addSenderFragment(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SenderFragment())
            .commit()
    }

    private fun replaceSenderFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SenderFragment())
            .commit()
    }
}
