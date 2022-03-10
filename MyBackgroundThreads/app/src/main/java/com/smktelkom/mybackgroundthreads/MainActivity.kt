package com.smktelkom.mybackgroundthreads

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.smktelkom.mybackgroundthreads.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindingMain.root)

        val btnStart = bindingMain.btnStart
        val tvStatus = bindingMain.tvStatus
        val tvHidden = bindingMain.hiddenTv



        //val executor = Executors.newSingleThreadExecutor()
       // val handler = Handler(Looper.getMainLooper())

        btnStart.setOnClickListener{
            lifecycleScope.launch(Dispatchers.Default){
                try {
                    //simulate process in background thread here
                        btnStart.setBackgroundColor(Color.MAGENTA)
                    for(i in 0..10){
                        delay(500)
                        val percentage = i * 10

                        // Update ui in main thread here
                        withContext(Dispatchers.Main){
                            if(percentage == 100){
                                tvStatus.text = getString(R.string.task_completed)
                                tvHidden.visibility = View.VISIBLE
                                btnStart.setBackgroundColor(Color.BLUE)
                            }else{
                                tvStatus.text = String.format(getString(R.string.compressing), percentage)
                                tvHidden.visibility = View.GONE
                            }
                        }
                    }
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }

            /*executor.execute{
                try {
                    //simulate process in background thread here
                    for(i in 0..10){
                        Thread.sleep(500)
                        val percentage = i * 10
                        handler.post{
                            //update the UI here
                            if(percentage == 100){
                                tvStatus.text = getString(R.string.task_completed)
                                tvHidden.visibility = View.VISIBLE
                            }else{
                                tvStatus.text = String.format(getString(R.string.compressing), percentage)
                            }
                        }
                    }
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }*/
        }


    }
}