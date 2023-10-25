package io.github.l2hyunwoo.translator.android.translate.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.l2hyunwoo.translator.core.presentation.UiLanguage

@Composable
fun LanguageDropdownItem(
    language: UiLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        text = {
            Text(
                text = language.language.langName.lowercase().capitalize(Locale.current)
            )
        },
        onClick = onClick,
        leadingIcon = {
            Image(
                painter = painterResource(id = language.drawableRes),
                contentDescription = language.language.langName,
                modifier = Modifier.size(40.dp)
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun LanguageDropdownItemPreview() {
    LanguageDropdownItem(
        language = UiLanguage.byCode("ko"),
        onClick = {}
    )
}
