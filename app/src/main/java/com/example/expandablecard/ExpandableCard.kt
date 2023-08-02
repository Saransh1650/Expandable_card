package com.example.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(){
    var expandedState by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(
        targetValue =
        if (expandedState) 180f
        else 0f,
        label = ""
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = ShapeDefaults.Medium,
        onClick = {
            expandedState = !expandedState
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "Title",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                )
                IconButton(
                    modifier = Modifier
                        .alpha(alpha = 0.5F)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = { expandedState = !expandedState }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand Content"
                    )

                }
            }
            
            if(expandedState){
                Text(text = "........................................." +
                        "..............................................." +
                        "..............................................." +
                        ".................................................." +
                        "................................................" +
                        "................................................" +
                        "................................................",
                style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal)
                )
            }
        }
    }



}

@Composable
@Preview
fun ExpandableCardPreview(){
    ExpandableCard()
}