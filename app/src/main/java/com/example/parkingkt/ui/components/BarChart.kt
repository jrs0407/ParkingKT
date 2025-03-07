package com.example.parkingkt.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round

@Composable
fun BarChart(){
    val chartData = listOf(
        Pair("1", 90),
        Pair("2", 100),
        Pair("3", 110),
        Pair("4", 120),
        Pair("5", 130),
        Pair("6", 140)
    )
    val spacingFromLeft = 100f
    val spacingFromBottom = 40f
    val upperValue = remember { (chartData.maxOfOrNull { it.second }?.plus(1)) ?: 0 }
    val lowerValue = remember { (chartData.minOfOrNull { it.second }?.toInt() ?: 0) }
    val density = LocalDensity.current

    //paint for the text shown in data values
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.White)
            .padding(15.dp)
    ) {
        val canvasHeight = size.height
        val canvasWidth = size.width

        val spacePerData = (canvasWidth - spacingFromLeft) / chartData.size

        //loop through each index by step of 1
        //data shown horizontally
        (chartData.indices step 1).forEach { i ->
            val text = chartData[i].first
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    text,
                    spacingFromLeft + 30f + i * spacePerData,
                    canvasHeight,
                    textPaint
                )
            }
        }

        val valuesToShow = 5f  //we will show 5 data values on vertical line

        val eachStep = (upperValue - lowerValue) / valuesToShow
        //data shown vertically
        (0..4).forEach { i ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + eachStep * i).toString(),
                    20f,
                    canvasHeight - 30f - i * canvasHeight / 5f,
                    textPaint
                )
            }

            //draw horizontal line at each value
            drawLine(
                start = Offset(
                    spacingFromLeft - 20f,
                    canvasHeight - spacingFromBottom - i * canvasHeight / 5f
                ),
                end = Offset(
                    spacingFromLeft,
                    canvasHeight - spacingFromBottom - i * canvasHeight / 5f
                ),
                color = Color.Black,
                strokeWidth = 3f
            )
        }
        //Vertical line
        drawLine(
            start = Offset(spacingFromLeft, canvasHeight - spacingFromBottom),
            end = Offset(spacingFromLeft, 0f),
            color = Color.Black,
            strokeWidth = 3f
        )

        //Horizontal line
        drawLine(
            start = Offset(spacingFromLeft, canvasHeight - spacingFromBottom),
            end = Offset(canvasWidth - 40f, canvasHeight - spacingFromBottom),
            color = Color.Black,
            strokeWidth = 3f
        )

        //draw bars
            chartData.forEachIndexed { index, chartPair ->

                //draw text at top of each bar
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        chartPair.second.toString(),
                        spacingFromLeft + 40f + index * spacePerData,
                        (upperValue - chartPair.second.toFloat()) / upperValue * canvasHeight - 10f,
                        textPaint
                    )
                }

                //draw Bar for each value
                drawRoundRect(
                    color = Color.Magenta,
                    topLeft = Offset(
                        spacingFromLeft + 10f + index * spacePerData,
                        (upperValue - chartPair.second.toFloat()) / upperValue * canvasHeight
                    ),
                    size = Size(
                        55f,
                        (chartPair.second.toFloat() / upperValue) * canvasHeight - spacingFromBottom
                    ),
                    cornerRadius = CornerRadius(10f, 10f)
                )
            }
    }
}