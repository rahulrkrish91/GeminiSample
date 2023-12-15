package com.example.sampleapp.use_case

import android.content.Context
import android.graphics.BitmapFactory
import com.example.sampleapp.R
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import javax.inject.Inject

class GetWhatIsInImageUseCase @Inject constructor(

) {

    suspend operator fun invoke(context: Context): String {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro-vision",
            apiKey = "AIzaSyD8W5v0btkZOBfwOYpp1XqLa4xWk_Q1duE"
        )
        val input = content {
            image(BitmapFactory.decodeResource(context.resources, R.drawable.kannur_beach))
            text("What is in the image?")
        }
        val response = generativeModel.generateContent(input)
        return response.text.toString()
    }
}