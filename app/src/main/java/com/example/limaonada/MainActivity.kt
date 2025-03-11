package com.example.limaonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limaonada.R
import com.example.limaonada.ui.theme.LimaonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimaonadaTheme {
                AppLimao()
            }
        }
    }
}

@Composable
fun AppLimao() {
    var imagematual by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color(red = 249, green = 228, blue = 76, alpha = 255))
                    .align(Alignment.TopCenter)
            ) {
                Text(
                    text = "Limonada",
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            when (imagematual) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.lemon_tree_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(196, 236, 212),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(105, 205, 216),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {
                                    imagematual = 2
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = stringResource(R.string.limoeiro),
                            fontSize = 25.sp
                        )
                    }
                }

                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        var limao = (1..4).random()
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.lemon_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(196, 236, 212),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(105, 205, 216),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {
                                    when (limao) {
                                        1 -> imagematual = 3
                                        else -> limao -= 1
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = stringResource(R.string.limao),
                            fontSize = 20.sp
                        )
                    }
                }

                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.copo_de_limonada),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(196, 236, 212),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(105, 205, 216),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {
                                    imagematual = 4
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = stringResource(R.string.limonada),
                            fontSize = 25.sp
                        )
                    }
                }

                else -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.Copo_vazio),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(
                                    color = Color(196, 236, 212),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = 2.dp,
                                    color = Color(105, 205, 216),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {
                                    imagematual = 1
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = stringResource(R.string.copo_vazio),
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LimaonadaTheme {
        AppLimao()
    }
}