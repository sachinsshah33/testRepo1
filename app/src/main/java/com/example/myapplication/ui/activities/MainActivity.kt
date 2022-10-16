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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Constants
import com.example.myapplication.databinding.CircularProgressViewNewBinding
import com.example.myapplication.ui.extensions.toPercentageOutOf1
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.views.CircularProgressView
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



        SubscriptionMilesLeftCircularProgressIndicator(viewModel)
        LastEnergyLevelCircularProgressIndicator(viewModel)
        Button(onClick = { viewModel.fetchUser() }) {
            Text(text = stringResource(id = R.string.button_refresh))
        }





        Text(text = "Test stuff below") //fixme, this just showed a refresh icon for some reason...
        AndroidView(
            modifier = Modifier.size(size = 112.dp),
            factory = {
                CircularProgressView(it).apply {
                    binding.progressBar.max = Constants.subscriptionMilesLeftMax
                }
            },
            update = {
                it.binding.progressBar.progress = viewModel.subscriptionMilesLeft
            }
        )

        CircularProgressViewNewBinding(viewModel = viewModel)
    }
}

@Composable
fun CircularProgressViewNewBinding(modifier: Modifier = Modifier.size(size = 112.dp), viewModel: UserViewModel = viewModel()) {
    AndroidViewBinding(CircularProgressViewNewBinding::inflate, modifier = modifier) {
        progressBar.max = Constants.subscriptionMilesLeftMax
        progressBar.progress = viewModel.subscriptionMilesLeft
    }
}





@Preview
@Composable
fun CommonCircularProgressIndicator(modifier: Modifier = Modifier.size(size = 112.dp), value: Int = 0, max: Int = 100, color: Color = Color.Magenta, strokeWidthDp: Int = 6) {
    val animatedProgress = animateFloatAsState(
        targetValue = value.toPercentageOutOf1(max),
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    CircularProgressIndicator(
        progress = animatedProgress,
        modifier = modifier,
        color = color,
        strokeWidth = strokeWidthDp.dp
    )

    Text(text = value.toString())
}

@Composable
fun SubscriptionMilesLeftCircularProgressIndicator(viewModel: UserViewModel = viewModel()) {
    CommonCircularProgressIndicator(
        value = viewModel.subscriptionMilesLeft, max = Constants.subscriptionMilesLeftMax
    )
}

@Composable
fun LastEnergyLevelCircularProgressIndicator(viewModel: UserViewModel = viewModel()) {
    CommonCircularProgressIndicator(
        value = viewModel.lastEnergyLevel, max = Constants.lastEnergyLevelMax
    )
}