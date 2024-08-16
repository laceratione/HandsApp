package ru.android.handsapp.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.android.handsapp.R
import ru.android.handsapp.model.BaseCell
import ru.android.handsapp.ui.theme.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: CelliesViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                onCreateClick = { viewModel.create() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 15.dp, bottom = 16.dp)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 22.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            CellList(cellies = viewModel.cellies, contentPadding = it)
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.title_app_bar),
        fontFamily = roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun BottomBar(onCreateClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onCreateClick, shape = RoundedCornerShape(4.dp), modifier = modifier) {
        Text(
            text = stringResource(id = R.string.btn_create).uppercase(),
            fontFamily = roboto,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Composable
fun CellList(cellies: List<BaseCell>, contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn(contentPadding = contentPadding) {
        items(cellies) { cell ->
            CellItemList(
                cell = cell,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun CellItemList(cell: BaseCell, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(brush = cell.brush)
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .height(40.dp)
                        .width(21.dp),
                    painter = painterResource(id = cell.image),
                    contentDescription = ""
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = cell.title,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = cell.subTitle,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}