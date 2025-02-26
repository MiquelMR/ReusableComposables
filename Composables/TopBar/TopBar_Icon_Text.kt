package com.mmauridev.composables.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A customizable Top Bar with a navigation back button and a title.
 *
 * @param text The title text displayed in the top bar.
 * @param iconsSize The size of the icons in the top bar (default is 24).
 * @param fontSize The font size of the title text (default is 12).
 * @param fontWeight The font weight of the title text (default is FontWeight.Bold).
 * @param paddingValues The padding around the components in the top bar (default is 4).
 * @param iconRightPadding The padding to the right of the icon (default is 8).
 * @param titleAlignment The alignment of the title (Left, Center, or Right).
 * @param textColor The color of the title text (default is MaterialTheme.colorScheme.primary).
 * @param iconTint The tint color of the icons (default is MaterialTheme.colorScheme.primary).
 * @param backgroundColor The background color of the top bar (default is MaterialTheme.colorScheme.background).
 * @param fontFamily The font family of the title text (default is FontFamily.Serif).
 * @param leftIcon The icon displayed on the left side (default is Icons.AutoMirrored.Filled.ArrowBack).
 * @param onBackButtonClick The callback function when the back button is clicked (no use by default).
 */
@Composable
fun TopBar_Icon_Text(
    text: String,
    iconsSize: Int = 24,
    fontSize: Int = 12,
    fontWeight: FontWeight = FontWeight.Bold,
    paddingValues: Int = 4,
    iconRightPadding: Int = 8,
    titleAlignment: TitleAlignment = TitleAlignment.Left,
    textColor: Color = MaterialTheme.colorScheme.primary,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    fontFamily: FontFamily = FontFamily.Serif,
    leftIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    onBackButtonClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(PaddingValues(paddingValues.dp))
    ) {
        IconButton(modifier = Modifier
            .size(iconsSize.dp),
            onClick = onBackButtonClick,
            content = {
                Icon(
                    tint = iconTint,
                    imageVector = leftIcon,
                    contentDescription = "Left icon"
                )
            })

        when (titleAlignment) {
            TitleAlignment.Left -> {
                Spacer(
                    Modifier.padding(0.dp, 0.dp, end = iconRightPadding.dp, 0.dp)
                )
                Text(
                    overflow = TextOverflow.Ellipsis,
                    color = textColor,
                    maxLines = 1,
                    fontSize = fontSize.sp,
                    fontFamily = fontFamily,
                    fontWeight = fontWeight,
                    text = text
                )
                Spacer(Modifier.weight(1f))
            }

            TitleAlignment.Center -> {
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    color = textColor,
                    maxLines = 1,
                    fontSize = fontSize.sp,
                    fontFamily = fontFamily,
                    fontWeight = fontWeight,
                    text = text
                )
                Spacer(Modifier)
            }

            TitleAlignment.Right -> {
                Spacer(Modifier.weight(1f))
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

    }
}

enum class TitleAlignment {
    Left, Center, Right
}