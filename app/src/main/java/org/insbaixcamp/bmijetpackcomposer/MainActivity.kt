package org.insbaixcamp.bmijetpackcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.bmijetpackcomposer.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIJetpackComposerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMIScreen()
                }
            }
        }
    }
}

@Composable
fun BMIScreen() {
    var name by remember { mutableStateOf("Tarnished") }
    var pes by remember { mutableIntStateOf(80) }
    var alçada by remember { mutableFloatStateOf(180f) }
    var bmi by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(EldenBackground)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Text(
                text = "THE LANDS BETWEEN",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = EldenDarkGold,
                letterSpacing = 3.sp
            )
            Text(
                text = "STATUS OF THE TARNISHED",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = EldenGold,
                letterSpacing = 1.sp
            )

            HorizontalDivider(
                color = EldenBorder,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            // Main Card Container
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .border(BorderStroke(1.dp, EldenBorder), RoundedCornerShape(4.dp)),
                colors = CardDefaults.cardColors(containerColor = EldenCardBg),
                shape = RoundedCornerShape(4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Name Field
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "TARNISHED NAME",
                            fontSize = 11.sp,
                            color = EldenTextSecondary,
                            letterSpacing = 1.5.sp
                        )
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = EldenGold,
                                unfocusedBorderColor = EldenBorder,
                                focusedTextColor = EldenTextPrimary,
                                unfocusedTextColor = EldenTextPrimary,
                                cursorColor = EldenGold,
                                focusedContainerColor = EldenSurface,
                                unfocusedContainerColor = EldenSurface
                            ),
                            singleLine = true
                        )
                    }

                    // Weight (Pes)
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "EQUIPMENT WEIGHT (PES)",
                            fontSize = 11.sp,
                            color = EldenTextSecondary,
                            letterSpacing = 1.5.sp
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(EldenSurface, RoundedCornerShape(4.dp))
                                .border(BorderStroke(1.dp, EldenBorder), RoundedCornerShape(4.dp))
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "$pes Kg",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = EldenGold
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                    onClick = { if (pes > 20) pes-- },
                                    colors = ButtonDefaults.buttonColors(containerColor = EldenCardBg),
                                    border = BorderStroke(1.dp, EldenBorder),
                                    shape = RoundedCornerShape(2.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                                ) {
                                    Text("-", color = EldenGold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                                Button(
                                    onClick = { if (pes < 300) pes++ },
                                    colors = ButtonDefaults.buttonColors(containerColor = EldenCardBg),
                                    border = BorderStroke(1.dp, EldenBorder),
                                    shape = RoundedCornerShape(2.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                                ) {
                                    Text("+", color = EldenGold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }

                    // Height (Alçada)
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "STATURE (ALÇADA)",
                                fontSize = 11.sp,
                                color = EldenTextSecondary,
                                letterSpacing = 1.5.sp
                            )
                            Text(
                                text = "${alçada.toInt()} cm",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = EldenGold
                            )
                        }
                        Slider(
                            value = alçada,
                            onValueChange = { alçada = it },
                            valueRange = 100f..220f,
                            colors = SliderDefaults.colors(
                                thumbColor = EldenGold,
                                activeTrackColor = EldenGold,
                                inactiveTrackColor = EldenSurface
                            )
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Calculate Button
                    Button(
                        onClick = {
                            val alçadaMetres = alçada / 100f
                            bmi = (pes.toFloat() / (alçadaMetres * alçadaMetres))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = EldenSurface,
                            contentColor = EldenGold
                        ),
                        border = BorderStroke(1.dp, EldenGold),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "EXAMINE GREAT RUNE (CALCULATE BMI)",
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp,
                            fontSize = 13.sp,
                            color = EldenGold
                        )
                    }

                    // Result Display
                    if (bmi != 0f) {
                        val loadStatus = when {
                            bmi < 18.5f -> "Light Load (Emaciated)"
                            bmi < 25f -> "Medium Load (Balanced Physique)"
                            bmi < 30f -> "Heavy Load (Slightly Overweight)"
                            else -> "Overburdened (Fat Roll!)"
                        }
                        val statusColor = if (bmi >= 30f) EldenCrimson else EldenGold

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(EldenSurface, RoundedCornerShape(4.dp))
                                .border(BorderStroke(1.dp, statusColor), RoundedCornerShape(4.dp))
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "GREAT RUNE BMI: ${String.format("%.2f", bmi)}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = statusColor
                            )
                            Text(
                                text = loadStatus,
                                fontSize = 12.sp,
                                color = EldenTextPrimary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMIJetpackComposerTheme {
        BMIScreen()
    }
}
