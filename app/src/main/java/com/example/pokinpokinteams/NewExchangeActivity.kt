package com.example.pokinpokinteams

import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.ComponentActivity

class NewExchangeActivity : ComponentActivity() {

    private var selectedImageUri: Uri? = null

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedImageUri = uri
            findViewById<ImageView>(R.id.plushiePreview).setImageURI(uri)
            findViewById<TextView>(R.id.uploadHint).text = "Photo selected ✓"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_exchange)

        val uploadBox = findViewById<LinearLayout>(R.id.uploadBox)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val pointsInput = findViewById<EditText>(R.id.pointsInput)

        val confirmBtn = findViewById<TextView>(R.id.confirmBtn)
        val cancelBtn = findViewById<TextView>(R.id.cancelBtn)

        uploadBox.setOnClickListener {
            pickImage.launch("image/*")
        }

        cancelBtn.setOnClickListener {
            finish()
        }

        confirmBtn.setOnClickListener {
            val phone = phoneInput.text.toString().trim()
            val pointsStr = pointsInput.text.toString().trim()
            val points = pointsStr.toIntOrNull()

            if (selectedImageUri == null) {
                toast("Please upload a plushie photo")
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                phoneInput.error = "Phone number required"
                return@setOnClickListener
            }
            if (points == null || points <= 0) {
                pointsInput.error = "Points must be a positive number"
                return@setOnClickListener
            }

            // TODO: 在这里接后端：上传图片 + 写入 exchange 记录 + 给用户加 points
            toast("Exchange created: $phone (+$points points)")

            finish()
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
