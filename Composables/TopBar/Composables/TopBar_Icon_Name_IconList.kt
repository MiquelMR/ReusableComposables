package com.mmauridev.composables.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmauridev.composables.R

@Composable
fun TopBar_Icon_Name_IconList(
    leftSideImage: Int? = null,
    text: String? = null,
    icons: List<IconData> = listOf(),

    imageSize: Int = 40,
    iconsSize: Int = 20,
    fontSize: Int = 14,

    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = FontFamily.Default,
    paddingBetweenIcons: Int = 8,

    textColor: Color = MaterialTheme.colorScheme.primary,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,

    // Rename this function to be more descriptive based on the event it handles
    onLeftImageClick: () -> Unit = {},
    onBackButtonClick: () -> Unit = {},

    // These values can help impaired individuals
    contentDescription: String = "This is an image, it is intended to represent the user avatar"


) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            IconButton(modifier = Modifier
                .size(iconsSize.dp),
                onClick = onBackButtonClick,
                content = {
                    Icon(
                        tint = iconTint,
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Left icon"
                    )
                })

            if (leftSideImage != null) {
                IconButton(
                    modifier = Modifier.size(imageSize.dp),
                    onClick = onLeftImageClick
                ) {
                    Image(
                        painter = painterResource(leftSideImage),
                        contentDescription = contentDescription
                    )
                }
            }
            if (text != null) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    overflow = TextOverflow.Ellipsis,
                    color = textColor,
                    maxLines = 1,
                    fontSize = fontSize.sp,
                    fontFamily = fontFamily,
                    fontWeight = fontWeight,
                    text = text
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icons.forEach {
                IconButton(
                    modifier = Modifier.size(iconsSize.dp),
                    onClick = it.onClick,
                    content = {
                        Icon(
                            tint = iconTint,
                            imageVector = it.imageVector,
                            contentDescription = it.contentDescription
                        )
                    }
                )
                Spacer(modifier = Modifier.width(paddingBetweenIcons.dp))
            }
        }
    }
}

data class IconData(
    val imageVector: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit
)


@Preview
@Composable
fun TopBar_Icon_Name_IconListPreview() {
    val icons = listOf(
        IconData(
            imageVector = Icons.Outlined.Email,
            contentDescription = "Email",
            onClick = {}
        ),
        IconData(
            imageVector = Icons.Outlined.Call,
            contentDescription = "Call",
            onClick = {}
        ),
        IconData(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = "More options",
            onClick = {}
        ))

    TopBar_Icon_Name_IconList(
        iconTint = Color.White,
        backgroundColor = Color.Black,
        textColor = Color.White,
        fontFamily = FontFamily.Default,
        leftSideImage = R.drawable.avatar,
        text = "Margarita",
        paddingBetweenIcons = 16,
        icons = icons
    )
}

