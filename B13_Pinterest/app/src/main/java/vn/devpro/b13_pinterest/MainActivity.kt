package vn.devpro.b13_pinterest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PinterestScreen()
            }
        }
    }
}


data class PinterestItem(
    val image: Int
)


@Composable
fun PinterestScreen() {

    val images = listOf(
        PinterestItem(R.drawable.image_1),
        PinterestItem(R.drawable.image_2),
        PinterestItem(R.drawable.image_3),
        PinterestItem(R.drawable.image_4),
        PinterestItem(R.drawable.image_5),
        PinterestItem(R.drawable.image_6),
        PinterestItem(R.drawable.image_7),
        PinterestItem(R.drawable.image_8),
        PinterestItem(R.drawable.image_9),
        PinterestItem(R.drawable.image_10)
    )

    var selectedCategory by remember {
        mutableStateOf("For You")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 14.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Pinterest",
                color = Color(0xFFE60023),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.size(28.dp)
            )

            Spacer(
                modifier = Modifier.width(18.dp)
            )

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.size(28.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 6.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            CategoryItem(
                text = "For You",
                selected = selectedCategory == "For You"
            ) {
                selectedCategory = "For You"
            }

            CategoryItem(
                text = "Popular",
                selected = selectedCategory == "Popular"
            ) {
                selectedCategory = "Popular"
            }

            CategoryItem(
                text = "Design",
                selected = selectedCategory == "Design"
            ) {
                selectedCategory = "Design"
            }

            CategoryItem(
                text = "Technology",
                selected = selectedCategory == "Technology"
            ) {
                selectedCategory = "Technology"
            }

            CategoryItem(
                text = "Art",
                selected = selectedCategory == "Art"
            ) {
                selectedCategory = "Art"
            }
        }


        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),

            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),

            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 6.dp,
                bottom = 8.dp
            ),

            horizontalArrangement = Arrangement.spacedBy(8.dp),

            verticalItemSpacing = 8.dp
        ) {

            items(images) { item ->

                Image(
                    painter = painterResource(
                        id = item.image
                    ),

                    contentDescription = null,

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(14.dp)
                        ),

                    contentScale = ContentScale.Crop
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White),

            horizontalArrangement = Arrangement.SpaceEvenly,

            verticalAlignment = Alignment.CenterVertically
        ) {

            BottomIcon(
                icon = Icons.Default.Home
            )

            BottomIcon(
                icon = Icons.Default.Search
            )

            BottomIcon(
                icon = Icons.Default.Notifications
            )

            BottomIcon(
                icon = Icons.Default.Person
            )
        }
    }
}


@Composable
fun CategoryItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(
                if (selected) {
                    Color(0xFFE60023)
                } else {
                    Color.Transparent
                }
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 16.dp,
                vertical = 9.dp
            )
    ) {

        Text(
            text = text,

            fontSize = 14.sp,

            fontWeight = FontWeight.Bold,

            color = if (selected) {
                Color.White
            } else {
                Color.Black
            }
        )
    }
}


@Composable
fun BottomIcon(
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {

    Icon(
        imageVector = icon,

        contentDescription = null,

        tint = Color.Black,

        modifier = Modifier.size(27.dp)
    )
}
