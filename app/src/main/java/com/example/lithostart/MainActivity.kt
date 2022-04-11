package com.example.lithostart

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

class MainActivity : AppCompatActivity() {

    lateinit var buttonOnInstall:Button
    lateinit var buttonOnDemand:Button
    lateinit var progress:ProgressDialog
    lateinit var splitInstallManager: SplitInstallManager
    var mySessionId:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonOnDemand = findViewById(R.id.onDemand)
        buttonOnInstall = findViewById(R.id.onInstall)

        splitInstallManager = SplitInstallManagerFactory.create(this)

        progress = ProgressDialog(this);
        progress.setTitle("Feature Message")

        var intent = Intent();

        buttonOnDemand.setOnClickListener {
           var splitInstallRequest = SplitInstallRequest.newBuilder().addModule("ondemand").build()

            var listener:SplitInstallStateUpdatedListener = SplitInstallStateUpdatedListener {
                if(it.sessionId()==mySessionId){

                    when(it.status()){

                        SplitInstallSessionStatus.CANCELED -> {

                        }
                        SplitInstallSessionStatus.CANCELING -> {

                        }
                        SplitInstallSessionStatus.DOWNLOADED -> {

                        }
                        SplitInstallSessionStatus.DOWNLOADING -> {
                            progress.setMessage("Downloading")
                            progress.show()
                        }
                        SplitInstallSessionStatus.FAILED -> {

                        }
                        SplitInstallSessionStatus.INSTALLED -> {
                            startActivity(Intent().setClassName(BuildConfig.APPLICATION_ID,"com.example.ondemand.MainActivity"))
                        }
                        SplitInstallSessionStatus.INSTALLING -> {

                        }
                        SplitInstallSessionStatus.PENDING -> {

                        }
                        SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {

                        }
                        SplitInstallSessionStatus.UNKNOWN -> {

                        }
                    }
                }
            }


            splitInstallManager.registerListener(listener)


            splitInstallManager.startInstall(splitInstallRequest).addOnFailureListener {
                e->
                Log.d("exception", "exception is: $e")
            }.addOnSuccessListener {
                sessionId -> mySessionId = sessionId
            }
        }

        buttonOnInstall.setOnClickListener {
            intent.setClassName(BuildConfig.APPLICATION_ID, "com.example.oninstall.MainActivity")
            startActivity(intent)
        }
    }
}