package kh.edu.rupp.ite.calculator

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.*


class MainActivity<Expression> : AppCompatActivity() {

    private final var display: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.displayEditText)
        display!!.setShowSoftInputOnFocus(false); //prevent keyboard from pop up
    }

    private fun updateText(strToAdd: String){
        val oldStr = display!!.text.toString()
        val cursor = display!!.selectionStart
        val leftStr = oldStr.substring(0, cursor)
        val rightStr = oldStr.substring(cursor)

        display!!.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display!!.setSelection(cursor + strToAdd.length);
    }

//    Number
    fun zeroBTN(view: View?) {
        updateText(resources.getString(R.string.button_0_text))
    }
    fun oneBTN(view: View?) {
        updateText(resources.getString(R.string.button_1_text))
    }
    fun twoBTN(view: View?) {
        updateText(resources.getString(R.string.button_2_text))
    }
    fun threeBTN(view: View?) {
        updateText(resources.getString(R.string.button_3_text))
    }
    fun fourBTN(view: View?) {
        updateText(resources.getString(R.string.button_4_text))
    }
    fun fiveBTN(view: View?) {
        updateText(resources.getString(R.string.button_5_text))
    }
    fun sixBTN(view: View?) {
        updateText(resources.getString(R.string.button_6_text))
    }
    fun sevenBTN(view: View?) {
        updateText(resources.getString(R.string.button_7_text))
    }
    fun eightBTN(view: View?) {
        updateText(resources.getString(R.string.button_8_text))
    }
    fun nineBTN(view: View?) {
        updateText(resources.getString(R.string.button_9_text))
    }

//    symbol + - * /
    fun plusBTN(view: View?) {
        updateText(resources.getString(R.string.button_plus_text))
    }
    fun minusBTN(view: View?) {
        updateText(resources.getString(R.string.button_minus_text))
    }
    fun multiplyBTN(view: View?) {
        updateText(resources.getString(R.string.button_multi_text))
    }
    fun divideBTN(view: View?) {
        updateText(resources.getString(R.string.button_divide_text))
    }
    fun parLeftBTN(view: View?) {
        updateText(resources.getString(R.string.par_Left_Text))
    }
    fun parRightBTN(view: View?) {
        updateText(resources.getString(R.string.par_Right_Text))
    }

    fun dotBTN(view: View?) {
        updateText(resources.getString(R.string.button_dot_text))
    }

    fun ACBTN(view: View?) {
        display!!.setText("")
    }
    fun delBTN(view: View?) {
        val cursorPos = display!!.selectionStart
        val textLen = display!!.text.length
        if (cursorPos != 0 && textLen != 0) {
            val selection = display!!.text as SpannableStringBuilder
            selection.replace(cursorPos - 1, cursorPos, "")
            display!!.text = selection
            display!!.setSelection(cursorPos - 1)
        }
    }

    fun equalBTN(view: View?) {
        var userExp = display!!.text.toString()
        userExp = userExp.replace(resources.getString(R.string.button_divide_text).toRegex(), "/")
        userExp = userExp.replace(resources.getString(R.string.button_multi_text).toRegex(), "*")
        val exp: org.mariuszgromada.math.mxparser.Expression = Expression(userExp)
        val result: String = java.lang.String.valueOf(exp.calculate())

        display!!.setText(result)
        display!!.setSelection(result.length)
    }

}