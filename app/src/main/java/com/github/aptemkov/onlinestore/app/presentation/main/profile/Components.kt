package com.github.aptemkov.onlinestore.app.presentation.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R

@Preview(showBackground = true)
@Composable
fun ProfileButtonPreview() {
    ProfileButton(
        icon = painterResource(id = R.drawable.ic_credit_card),
        label = "Trade store",
        onClick = {},
        showEndArrow = true,
        showEndLabel = false
    )
}

@Composable
fun ProfileButton(
    icon: Painter,
    label: String,
    onClick: () -> Unit,
    showEndArrow: Boolean,
    showEndLabel: Boolean,
    endLabel: String = "$1593"
) {
    Row(
        Modifier
            .padding(bottom = 25.dp)
            .height(40.dp)
            .fillMaxWidth()
            .clickable { onClick() }

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically),
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(color = Color(0xffeeeff4), shape = CircleShape)
            ) {}

            Icon(
                painter = icon,
                contentDescription = "Navigation Icon $label"
            )
        }
        Text(
            text = label,
            color = Color(0xff040402),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )

        Spacer(Modifier.weight(1f))

        if (showEndArrow) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }

        if (showEndLabel) {
            Text(
                text = endLabel,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp),
            )
        }

    }
}

@Composable
fun ProfilePhoto(
    modifier: Modifier = Modifier,
    painter: Painter,
) {

    Image(
        painter = painter,
        contentDescription = "Profile icon",
        modifier = modifier
            .size(64.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(25.dp))
    )

}


