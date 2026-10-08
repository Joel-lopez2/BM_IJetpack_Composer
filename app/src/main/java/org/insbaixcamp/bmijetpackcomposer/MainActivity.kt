package org.insbaixcamp.bmijetpackcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var nombre by remember { mutableStateOf("Sin Luz") }
    var peso by remember { mutableIntStateOf(80) }
    var alçada by remember { mutableFloatStateOf(180f) }
    var bmi by remember { mutableFloatStateOf(0f) }

    val estadoScroll = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(EldenBackground)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(estadoScroll)
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Cabecera
            Text(
                text = "LAS TIERRAS INTERMEDIAS",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = EldenDarkGold,
                letterSpacing = 3.sp
            )
            Text(
                text = "ESTADO DEL SIN LUZ",
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

            // Tarjeta contenedora principal
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, EldenBorder), RoundedCornerShape(4.dp)),
                colors = CardDefaults.cardColors(containerColor = EldenCardBg),
                shape = RoundedCornerShape(4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Nombre del Sin Luz
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "NOMBRE DEL SIN LUZ",
                            fontSize = 11.sp,
                            color = EldenTextSecondary,
                            letterSpacing = 1.5.sp
                        )
                        OutlinedTextField(
                            value = nombre,
                            onValueChange = { nombre = it },
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

                    // Peso de equipamiento
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "PESO DE EQUIPAMIENTO (PESO)",
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
                                text = "$peso Kg",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = EldenGold
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                    onClick = { if (peso > 20) peso-- },
                                    colors = ButtonDefaults.buttonColors(containerColor = EldenCardBg),
                                    border = BorderStroke(1.dp, EldenBorder),
                                    shape = RoundedCornerShape(2.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                                ) {
                                    Text("-", color = EldenGold, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                                Button(
                                    onClick = { if (peso < 300) peso++ },
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

                    // Estatura
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "ESTATURA (ALÇADA)",
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

                    Spacer(modifier = Modifier.height(8.dp))

                    // Botón para calcular IMC
                    Button(
                        onClick = {
                            val alçadaMetres = alçada / 100f
                            bmi = (peso.toFloat() / (alçadaMetres * alçadaMetres))
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
                            text = "EXAMINAR GRAN RUNA (CALCULAR IMC)",
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp,
                            fontSize = 13.sp,
                            color = EldenGold
                        )
                    }

                    // Visualización del resultado
                    if (bmi != 0f) {
                        val estatCarga = when {
                            bmi < 18.5f -> "Carga Ligera (Emaciado - Bajo peso)"
                            bmi < 25f -> "Carga Media (Físico Equilibrado - Normal)"
                            bmi < 30f -> "Carga Pesada (Ligeramente Sobrepeso)"
                            else -> "Sobrecargado (¡Rodamiento Pesado! - Obesidad)"
                        }
                        val colorEstat = when {
                            bmi < 18.5f -> Color(0xFF5BC0DE) // Cian / Azul etéreo
                            bmi < 25f -> EldenGold // Oro de la Gracia
                            bmi < 30f -> Color(0xFFE67E22) // Ámbar de advertencia
                            else -> EldenCrimson // Rojo carmesí de peligro
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(EldenSurface, RoundedCornerShape(4.dp))
                                .border(BorderStroke(1.dp, colorEstat), RoundedCornerShape(4.dp))
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "IMC DE GRAN RUNA: ${String.format("%.2f", bmi)}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorEstat
                            )
                            Text(
                                text = estatCarga,
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
