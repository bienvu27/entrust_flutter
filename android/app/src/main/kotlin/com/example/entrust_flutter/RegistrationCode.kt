package com.example.entrust_flutter

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RegistrationCode : Activity() {
    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_code)
        // Display an explanation of what needs to be done with the registration code
        // plus the code itself.
        val regCode = findViewById<View>(R.id.regCode) as TextView
        regCode.text = Util.identity?.registrationCode
        val okButton = findViewById<View>(R.id.ok) as Button
        okButton.setOnClickListener {
            // Ask the user if they have used the registration code.
            Util.showConfirmationDialog(this@RegistrationCode, getString(R.string.confirm_regCodeUse)) { dialog, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    // If the answer is yes, clear out the registration code and move on to the security code.
                    Util.identity?.clearRegistrationCode()
                    startActivity(Intent(this@RegistrationCode, SecurityCode::class.java))
                    finish()
                } else {
                    // Return back to the Activity screen
                    dialog.cancel()
                }
            }
        }
    }
}