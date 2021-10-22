package com.example.jetpackcomposeunitconverter.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeunitconverter.model.RecentResult

@Composable
fun SingleRecentCalculation(
    recentCalculation: RecentResult
) {
    Card(
        elevation = 6.dp,
        shape = RoundedCornerShape(10.0f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = recentCalculation.converterType,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.Medium
                        )
                    ){
                        append(recentCalculation.amount)
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp,
                            color = MaterialTheme.colors.primary.copy(
                                alpha = 0.8f
                            )
                        )
                    ){
                        append(" ${recentCalculation.convertFrom} \t\t")
                    }

                    append("= \t\t")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.Medium
                        )
                    ){
                        append(recentCalculation.result)
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp,
                            color = MaterialTheme.colors.primary.copy(
                                alpha = 0.8f
                            )
                        )
                    ){
                        append(" ${recentCalculation.convertTo} \t\t")
                    }
                }
            )
        }
    }

}













