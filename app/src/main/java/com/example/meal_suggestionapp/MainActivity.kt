package com.example.meal_suggestionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meal_suggestionapp.ui.theme.Meal_SuggestionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Meal_SuggestionAppTheme {
                val timesofday = arrayOf("Morning","Mid-Morning Snack","Afternoon","Afternoon-Snack","Dinner","After Dinner Snack")
                var mealsuggestions = arrayOf("Pan Cakes,Smoothie", "Light Snack, Yoghurt", "Sandwich,Salad","Quick bites","Pasta,Stir Fry","Ice Cream,Fruit salad")

                var timeofday by remember {
                    mutableStateOf("Time of day ")
                }


                var result by remember {
                    mutableStateOf("")
                }

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()

                ){
                    Text(
                        "Meal Suggestion",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black

                    )
                    Divider()
                    Spacer(modifier = Modifier.size(30.dp) )

                    OutlinedTextField(
                        value = timeofday,
                        onValueChange = { text ->
                            timeofday = text
                        },
                        label = {
                            Text("Enter the time of day ")
                        }
                    )
                    Spacer(modifier = Modifier.size(30.dp) )
                    Row {
                        Button(
                            onClick = {
                                if (timeofday == timesofday[0]){
                                    result = mealsuggestions[0]
                                }else if(timeofday == timesofday[1]){
                                    result = mealsuggestions[1]
                                }else if(timeofday == timesofday[2]){
                                    result = mealsuggestions[2]
                                }else if(timeofday == timesofday[3]){
                                    result = mealsuggestions[3]
                                }else if(timeofday == timesofday[4]){
                                    result = mealsuggestions[4]
                                }else if(timeofday == timesofday[5]){
                                    result = mealsuggestions[5]
                                }else if(timeofday == timesofday[6]){
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
                                timeofday = ""
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

