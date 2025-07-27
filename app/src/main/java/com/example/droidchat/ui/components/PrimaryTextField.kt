package com.example.droidchat.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidchat.R
import com.example.droidchat.ui.theme.ColorError
import com.example.droidchat.ui.theme.DroidChatTheme

@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    @DrawableRes leadingIcon: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    errorMessage: String? = null,
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            singleLine = true,
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedBorderColor = if(errorMessage != null) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
            ),
            visualTransformation = if(keyboardType == KeyboardType.Password) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                if(keyboardType == KeyboardType.Password && value.isNotEmpty()) {
                    Icon(
                        painter = painterResource(R.drawable.ic_visibility_off),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary

                    )
                }
            },
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            placeholder = {
                Text(text = placeholder)
            }
        )

        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(16.dp)
            )
        }


    }
}

@Composable
private fun PrimaryBaseTextField(
    value: String,
    onValueChange: (String) -> Unit,
    errorMessage: String? = null,
    modifier: Modifier = Modifier,
    @DrawableRes leadingIcon: Int? = null,
) {
    Column(
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            decorationBox = { innerTextField ->
                Surface(
                    shape = CircleShape,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(16.dp)
                    ) {

                        leadingIcon?.let {
                            Image(
                                painter = painterResource(R.drawable.ic_envelope),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            innerTextField()
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(R.drawable.ic_bottom_nav_profile),
                            contentDescription = null
                        )
                    }
                }
            }
        )

        errorMessage?.let {
            Text(
                text = it,
                color = ColorError,
                modifier = Modifier
                    .padding(16.dp)
            )
        }


    }
}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {
    DroidChatTheme {
        PrimaryTextField(
            value = "",
            onValueChange = {},
            leadingIcon = R.drawable.ic_envelope,
            keyboardType = KeyboardType.Email,
            placeholder = "E-mail"
        )
    }
}