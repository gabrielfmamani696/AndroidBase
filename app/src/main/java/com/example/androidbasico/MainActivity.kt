package com.example.androidbasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasico.ui.theme.AndroidBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    AllLayoutFstExample()
//                    AnadirImagenLayout()
//                    TaskManagerLayout()
//                    CuadranteComposeLayout()
                    PresentationCardLayout()
                }
            }
        }
    }
}

@Composable
fun AllLayoutFstExample(modifier: Modifier = Modifier) {
    GreetingText(
        message = stringResource(R.string.happy_birthday_text),
        from = stringResource(R.string.signature_text),
        modifier = modifier
            .padding(8.dp)
    )
}

@Composable
fun AnadirImagenLayout(modifier: Modifier = Modifier){
    GreetingImage(
        message = stringResource(R.string.happy_birthday_text),
        from = stringResource(R.string.signature_text),
        modifier = modifier
    )
}

@Composable
fun ArticuloComposeLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun TaskManagerLayout(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice Work!",
            fontSize = 16.sp
        )
    }
}

@Composable
fun CuadranteComposeLayout(modifier: Modifier = Modifier) {
    // La Columna principal debe llenar toda la pantalla
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // FILA SUPERIOR (Ocupa el 50% de la altura)
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Cuadrante(
                title = "Text composable",
                content = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f) // 50% del ancho
            )
            Cuadrante(
                title = "Image composable",
                content = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f) // 50% del ancho
            )
        }

        // FILA INFERIOR (Ocupa el 50% de la altura restante)
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Cuadrante(
                title = "Row composable",
                content = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f) // 50% del ancho
            )
            Cuadrante(
                title = "Column composable",
                content = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f) // 50% del ancho
            )
        }
    }
}

@Composable
fun PresentationCardLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderLayout(
            modifier = Modifier.padding(bottom = 32.dp)
        )
        InfoLayout()
    }
}

@Composable
fun InfoLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // La columna ocupa todo el ancho
            .padding(16.dp) // Un poco de margen externo para que no toque los bordes
    ) {
        TextAndIconRow(
            info = "+591 76725650"

        )
        TextAndIconRow(
            info = "@usuario_social", // Ejemplo
            icon = Icons.Filled.Person
        )
        TextAndIconRow(
            info = "gabrielfmamanicatari@gmail.com",
            icon = Icons.Filled.Email
        )
    }
}

@Composable
fun HeaderLayout(
    modifier: Modifier = Modifier,
    nombre: String = "Gabriel",
    titulo: String = "Informatico",
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_head_3d),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp) // Un tamaño fijo para que no sea gigante
                .width(120.dp)
        )
        Text(
            text = nombre,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = titulo,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light,
        )
    }
}
@Composable
fun TextAndIconRow(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    info: String = "Def",
    icon: ImageVector = Icons.Filled.Phone
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = info,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}
@Composable
fun Cuadrante(
    title: String = "Default",
    content: String = "Default",
    color: Color = Color(0xFFEADDFF),
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}
@Composable
fun GreetingImage(message: String = "Default message", from: String = "Default from", modifier: Modifier = Modifier){
    //Los modificadores le indican a un elemento de la IU cómo aparecer o comportarse en su diseño de nivel superior.
    val image = painterResource(R.drawable.androidparty)
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            //ajustar el contenido
            contentScale = ContentScale.Crop,
            //cambiar la opacidad
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                //Modificadores de diseño
                //Los modificadores se usan para decorar o agregar comportamiento a los elementos de IU de Jetpack Compose. Por ejemplo, puedes agregar fondos, padding o comportamiento a filas, texto o botones. Para configurarlos, un elemento componible o un diseño debe aceptar un modificador como parámetro.
                //Al igual que en el ejemplo anterior, puedes agregar modificadores a los diseños para posicionar los elementos secundarios mediante propiedades de disposición y alineación.
                //Para establecer la posición de los elementos secundarios dentro de un Row, configura los argumentos horizontalArrangement y verticalAlignment. Para una Column, configura los argumentos verticalArrangement y horizontalAlignment.
                //https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-images#4
        )
    }
}
//Agregar una descripción de contenido para la imagen dificultaría el uso con TalkBack en este caso particular. En lugar de configurar la descripción del contenido que se anuncia al usuario, puedes establecer el argumento contentDescription de la imagen en null para que TalkBack omita el elemento Image que admite composición.

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AndroidBasicoTheme {
//        AllLayoutFstExample()
//        AnadirImagenLayout()
//        ArticuloComposeLayout()
//        TaskManagerLayout()
//        CuadranteComposeLayout()


//        InfoLayout()
        PresentationCardLayout()
    }
}