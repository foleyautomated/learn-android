package com.example.udemy_bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemy_bizcard.ui.theme.UdemyBizCardTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("CLicked", "createBizCard: ")



        setContent {
            UdemyBizCardTheme {
                CreateBizCard()
                // ScaffoldExample()

            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun ScaffoldExample() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Top app bar")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                    }
                ){
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }

        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                    """
                        This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
    
                        It also contains some basic inner content, such as this text.
    
                        You have pressed the floating action button multiple times.
                    """.trimIndent(),
                )
            }


        }
    }


    @Composable
    fun CreateBizCard() {
        //Value with state
        val buttonClickedState = remember {
            mutableStateOf(false);
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(180.dp)
                    .padding(12.dp),
                shape = RoundedCornerShape(corner = CornerSize(150.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.inversePrimary
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
            ) {
                Column(
                    modifier = Modifier.height(300.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateImageProfile()
                    HorizontalDivider(
                        thickness = 10.dp,
                        color = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                    ProfileInfo()
                    Button(
                        onClick = {
                            buttonClickedState.value = !buttonClickedState.value
                        }
                    ) {
                        Text(
                            text = "Portfolio",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    if(buttonClickedState.value) {
                        Content()
                    } else {
                        Box(){
                            //Empty Content
                        }
                    }

                }
            }
        }
    }


    @Composable
    private fun ProfileInfo() {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "David Foley",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Right
            )
            Text(
                text = "Fresh Android Compose Programmer",
                textAlign = TextAlign.Right
            )
        }
    }

    @Composable
    private fun CreateImageProfile(modifier: Modifier = Modifier) {
        Surface(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .padding(8.dp),
            shape = CircleShape,
            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.primary),
            shadowElevation = 2.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_symbol),
                contentDescription = "profile image",
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
    @Preview
    @Composable
    fun Content() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(5.dp)
        ){
            Surface(
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(width = 5.dp, color = MaterialTheme.colorScheme.secondaryContainer)
            ){
                Portfolio(data = listOf("Project 1","Project 2", "Project 3", "Project 4","Project 5"))

            }

        }
    }

    @Composable
    fun Portfolio(data: List<String>) {
        LazyColumn() {
            items(items = data, itemContent = { item ->
                Card(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxHeight(),
                    shape = RectangleShape,

                ){
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(MaterialTheme.colorScheme.surfaceTint)
                            .padding(16.dp)
                    ) {
                        CreateImageProfile(modifier = Modifier.size(10.dp))
                        Column(modifier = Modifier.padding(7.dp)) {
                            Text(text = item, fontWeight = FontWeight.Bold)
                        }
                    }
                }

            })

        }
    }


    //@Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        UdemyBizCardTheme {
            //ScaffoldExample();
            //CreateBizCard();
            Content()
        }
    }
}