package com.example.jetpackcomposeunitconverter.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun DropDownBox(
    dropDownList: List<String>,
    textValue: String,
    labelText: String,
    scrollState: ScrollState,
    isExpanded: Boolean,
    expandStatus: (Boolean) -> Unit = {},
    valueChange: (String) -> Unit = {}
) {
    Column {
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(
                    vertical = 5.dp,
                    horizontal = 10.dp
                )
                .clickable {
                    expandStatus(!isExpanded)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (textValue.isBlank())
                    Text(
                        text = labelText,
                        color = Color.Gray
                    )
                Text(text = textValue)
                IconButton(onClick = {
                    expandStatus(!isExpanded)
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Dropdown",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }

        AnimatedVisibility(visible = isExpanded) {
            Card(
                modifier = Modifier
                    .padding(top = 1.dp),
                elevation = 6.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = if (!isSystemInDarkTheme()) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeightIn(
                            max = 250.dp
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .verticalScroll(scrollState)
                ) {
                    dropDownList.forEach { label ->
                        DropdownMenuItem(onClick = {
                            valueChange(label)
                            expandStatus(false)
                        }) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.body1
                            )
                        }

                    }
                }
            }
        }
    }

}















