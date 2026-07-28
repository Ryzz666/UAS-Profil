package com.rury.profilemahasiswa.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rury.profilemahasiswa.ProfileViewModel
import com.rury.profilemahasiswa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    viewModel: ProfileViewModel,
    onNavigateBack: () -> Unit
) {
    var tempName by remember { mutableStateOf(viewModel.name) }
    var tempNim by remember { mutableStateOf(viewModel.nim) }
    var tempMajor by remember { mutableStateOf(viewModel.major) }
    var tempBio by remember { mutableStateOf(viewModel.bio) }
    var tempEmail by remember { mutableStateOf(viewModel.email) }
    var tempPhone by remember { mutableStateOf(viewModel.phone) }
    var tempAddress by remember { mutableStateOf(viewModel.address) }

    var nameError by remember { mutableStateOf(false) }
    var nimError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Edit Profil Mahasiswa",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            ProfilePhotoEditSection()

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "📝 Data Profil",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    EditRow(
                        icon = Icons.Rounded.Person,
                        label = "Nama Lengkap",
                        value = tempName,
                        onValueChange = { 
                            tempName = it
                            nameError = it.isEmpty()
                        },
                        isError = nameError,
                        errorMessage = "Nama tidak boleh kosong"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.Badge,
                        label = "NIM",
                        value = tempNim,
                        onValueChange = { 
                            tempNim = it
                            nimError = it.isEmpty()
                        },
                        isError = nimError,
                        errorMessage = "NIM tidak boleh kosong"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.Description,
                        label = "Bio",
                        value = tempBio,
                        onValueChange = { tempBio = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.School,
                        label = "Jurusan",
                        value = tempMajor,
                        onValueChange = { tempMajor = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.Email,
                        label = "Email",
                        value = tempEmail,
                        onValueChange = { tempEmail = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.Phone,
                        label = "Telepon",
                        value = tempPhone,
                        onValueChange = { tempPhone = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    EditRow(
                        icon = Icons.Rounded.LocationOn,
                        label = "Alamat",
                        value = tempAddress,
                        onValueChange = { tempAddress = it }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.weight(1f).height(50.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Batal")
                }

                Button(
                    onClick = {
                        if (tempName.isNotEmpty() && tempNim.isNotEmpty()) {
                            viewModel.name = tempName
                            viewModel.nim = tempNim
                            viewModel.bio = tempBio
                            viewModel.major = tempMajor
                            viewModel.email = tempEmail
                            viewModel.phone = tempPhone
                            viewModel.address = tempAddress
                            onNavigateBack()
                        }
                    },
                    modifier = Modifier.weight(1f).height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(Icons.Default.Save, contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Simpan")
                }
            }
        }
    }
}

@Composable
fun ProfilePhotoEditSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profil_photo),
                contentDescription = "Foto Profil",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .border(2.dp, Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.CameraAlt,
                contentDescription = "Foto Profil Tetap",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun EditRow(
    icon: ImageVector,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label, fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = isError,
            supportingText = if (isError) { { Text(errorMessage) } } else null,
            textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
            shape = RoundedCornerShape(12.dp)
        )
    }
}
