package com.rizvandavudov.explorehub.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rizvandavudov.explorehub.R
import com.rizvandavudov.explorehub.domain.model.CategoryType
import com.rizvandavudov.explorehub.domain.model.HomeCategory
import com.rizvandavudov.explorehub.ui.home.components.CategoryCard
import com.rizvandavudov.explorehub.ui.theme.ExploreHubTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onCategoryClick: (HomeCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    val errorMessage = uiState.errorMessage

    Box(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }

            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp)
                )
            }

            uiState.categories.isEmpty() -> {
                Text(
                    text = "Kateqoriya tapılmadı",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }

            else -> {
                HomeContent(
                    categories = uiState.categories,
                    onCategoryClick = onCategoryClick,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun HomeContent(
    categories: List<HomeCategory>,
    onCategoryClick: (HomeCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Kateqoriyalar",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 8.dp
            )
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = categories,
                key = { category ->
                    category.id
                }
            ) { category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        onCategoryClick(category)
                    }
                )
            }
        }
    }
}

@Preview(
    name = "Home content",
    showBackground = true
)
@Composable
private fun HomeScreenContentPreview() {
    ExploreHubTheme {
        HomeScreen(
            uiState = HomeUiState(
                isLoading = false,
                categories = listOf(
                    HomeCategory(
                        id = 1,
                        type = CategoryType.ANIMALS,
                        title = "Heyvanlar",
                        imageRes = R.drawable.animal
                    ),
                    HomeCategory(
                        id = 2,
                        type = CategoryType.CARS,
                        title = "Maşınlar",
                        imageRes = R.drawable.car
                    )
                ),
                errorMessage = null
            ),
            onCategoryClick = {}
        )
    }
}

@Preview(
    name = "Home loading",
    showBackground = true
)
@Composable
private fun HomeScreenLoadingPreview() {
    ExploreHubTheme {
        HomeScreen(
            uiState = HomeUiState(
                isLoading = true
            ),
            onCategoryClick = {}
        )
    }
}

@Preview(
    name = "Home error",
    showBackground = true
)
@Composable
private fun HomeScreenErrorPreview() {
    ExploreHubTheme {
        HomeScreen(
            uiState = HomeUiState(
                isLoading = false,
                errorMessage = "Kateqoriyalar yüklənmədi"
            ),
            onCategoryClick = {}
        )
    }
}