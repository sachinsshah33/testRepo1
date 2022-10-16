package com.example.myapplication.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import com.example.myapplication.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dashboard(userViewModel)
                }
            }
        }

        userViewModel.fetchUser()
    }
}

@Composable
fun Dashboard(viewModel: UserViewModel = viewModel()) {
    Column(modifier = Modifier.padding(16.dp)) {


        /*AndroidView(
            modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
            factory = { context ->
                CircularProgressView(context)
            },
            update = { view ->
                view.binding.progressBar.progress = viewModel.user?.subscription_miles_left?:0f
            }
        )*/


        SubscriptionMilesLeftCircularProgressIndicator(viewModel)
        LastEnergyLevelCircularProgressIndicator(viewModel)
        Button(onClick = { viewModel.fetchUser() }) {
            Text(text = stringResource(id = R.string.button_refresh))
        }
    }
}

/*@Composable
fun AndroidViewBindingExample(viewModel: UserViewModel = viewModel()) {
    AndroidViewBinding(CircularProgressViewNewBinding::inflate) {
        this.progressBar.progress = viewModel.user?.subscription_miles_left?:0f
    }
}*/


//@Preview
@Composable
fun SubscriptionMilesLeftCircularProgressIndicator(viewModel: UserViewModel = viewModel()) {
    val animatedProgress = animateFloatAsState(
        targetValue = viewModel.subscriptionMilesLeft,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    CircularProgressIndicator(
        progress = animatedProgress,
        modifier = Modifier.size(size = 64.dp),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}


@Composable
fun LastEnergyLevelCircularProgressIndicator(viewModel: UserViewModel = viewModel()) {
    val animatedProgress = animateFloatAsState(
        targetValue = viewModel.lastEnergyLevel,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    CircularProgressIndicator(
        progress = animatedProgress,
        modifier = Modifier.size(size = 64.dp),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}