package com.example.lithostart.ui.component

import android.graphics.drawable.Drawable
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lithostart.R


@Composable
fun MyToolbar(data:Toolbar){
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .height(55.dp)
        .background(color = Color.Unspecified)
        .fillMaxWidth(1f)) {
        Column (Modifier.padding(14.dp,0.dp,10.dp,0.dp)) {
            val image:Painter = painterResource(id = R.drawable.ic_back)
            Image(painter = image, contentDescription ="")
        }
        Column  {
            Text(text = data.title, fontSize = 22.sp)
        }
    }

}

@Composable
fun MyToolbar(data:Toolbar, action:ToolbarActions){
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .height(55.dp)
        .background(color = Color.Unspecified)
        .fillMaxWidth(1f)) {
        Column (Modifier.padding(14.dp,0.dp,10.dp,0.dp)) {
            val image:Painter = painterResource(id = R.drawable.ic_back)
            Image(painter = image, contentDescription ="")
        }
        Column  {
            Text(text = data.title, fontSize = 22.sp)
        }
        Column {
            if(data.actionButton==0){return}
            val actionImage:Painter = painterResource(id = data.actionButton)
//            Image(painter = )
        }
    }

}


@Preview
@Composable
fun show(){
    MyToolbar(data = Toolbar("Hello"))

}

interface ToolbarActions{
    fun onActionPressed()
}



data class Toolbar (
    val title:String,
    var actionButton:Int=0
        )

