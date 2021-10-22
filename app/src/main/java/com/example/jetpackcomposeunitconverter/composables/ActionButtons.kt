package com.example.jetpackcomposeunitconverter.composables

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeunitconverter.ui.theme.Cultured
import com.example.jetpackcomposeunitconverter.ui.theme.RoseMadder
import com.example.jetpackcomposeunitconverter.viewmodel.ConverterScreenViewModel

@Composable
fun ActionButtons(
    viewModel: ConverterScreenViewModel,
    converterTypeText: String,
    fromText: String,
    toText: String,
    amount: String,
    onReset: () -> Unit,
    onResultVisibilityChange: (Boolean) -> Unit
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .weight(1f),
            onClick = {
                if (!viewModel.validateFields(
                        converterType = converterTypeText,
                        convertFrom = fromText,
                        convertTo = toText
                    )
                ) {
                    onResultVisibilityChange(true)
                    viewModel.calculateResult(
                        converterType = converterTypeText,
                        convertFrom = fromText,
                        convertTo = toText,
                        amount = if (amount.isNotEmpty()) amount.toDouble() else 1.0
                    )
                } else {
                    Toast.makeText(context, "Please Select All Fields !!", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            elevation = ButtonDefaults.elevation(6.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "CONVERT",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
                onResultVisibilityChange(false)
                onReset()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = RoseMadder
            ),
            elevation = ButtonDefaults.elevation(6.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Cultured
            )
        }
    }
}
























