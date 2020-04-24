package xx.love.datastructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "xx"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val l1 = twoNumbers.Node(2)
        l1.next=twoNumbers.Node(4)
        val next = l1.next
        next?.next=twoNumbers.Node(3)
        val l2 = twoNumbers.Node(5)
        l2.next = twoNumbers.Node(6)
        val next1 = l2.next
        next1?.next = twoNumbers.Node(4)

        var twoNumbers = twoNumbers().addTwoNumbers(l1, l2)
        println(twoNumbers?.value)
        while (twoNumbers?.next != null) {
            twoNumbers = twoNumbers.next
            println(twoNumbers?.value)
        }
        val handler= Handler( object : Handler.Callback{
            override fun handleMessage(msg: Message?): Boolean {
                if (msg?.what==0){
                    println("ok")
                }
                return true
            }
        } )
        handler.sendEmptyMessage(1);
        handler.sendMessageAtTime(handler.obtainMessage(),1000)
    }
}
