package com.example.meal_suggestionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meal_suggestionapp.ui.theme.Meal_SuggestionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Meal_SuggestionAppTheme {
                val timesofday = arrayOf("Morning","Mid-Morning Snack","Afternoon","Afternoon-Snack","Dinner","After Dinner Snack")
                var mealsuggestions = arrayOf("Pan Cakes,Smoothie", "Light Snack, Yoghurt", "Sandwich,Salad","Quick bites","Pasta,Stir Fry","Ice Cream,Fruit salad")

                var usericon by remember {
                    mutableStateOf("")
                }


                var result by remember {
                    mutableStateOf("")
                }

                Column {
                    Text("Meal Suggestion")
                    OutlinedTextField(
                        value = usericon,
                        onValueChange = { text ->
                            usericon = text
                        },
                        label = {
                            Text("Enter icon name")
                        }
                    )

                    Row {
                        Button(
                            onClick = {
                                if (usericon == timesofday[0]){
                                    result = mealsuggestions[0]
                                }else if(usericon == timesofday[1]){
                                    result = mealsuggestions[1]
                                }else if(usericon == timesofday[2]){
                                    result = mealsuggestions[2]
                                }else if(usericon == timesofday[3]){
                                    result = mealsuggestions[3]
                                }else if(usericon == timesofday[4]){
                                    result = mealsuggestions[4]
                                }else if(usericon == timesofday[5]){
                                    result = mealsuggestions[5]
                                }else if(usericon == timesofday[6]){
                                    result = mealsuggestions[6]
                                }else{
                                    result = "Error!!!!!,Try Entering Morning,Afternoon,Dinner for valid Suggestions"
                                }
                            }
                        ) {
                            Text("Search")
                        }

                        Button(
                            onClick = {
                                usericon = ""
                                result = ""
                            }
                        ) {
                            Text("Clear")
                        }
                    }

                    Text("Your meal suggestion will appear here: $result")
                }
            }
            }
        }
    }

