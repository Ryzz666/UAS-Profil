package com.naufal.profilemahasiswa

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class MataKuliah(
    val kode: String,
    val nama: String,
    val sks: Int,
    val nilaiAngka: Int,
    val nilaiHuruf: String
)

class ProfileViewModel : ViewModel() {
    var name by mutableStateOf("NAUFAL DZAKI NIARDI")
    var nim by mutableStateOf("23083000159")
    var bio by mutableStateOf("A dedicated Information Systems student passionate about technology and software development.")
    var major by mutableStateOf("Sistem Informasi")
    var email by mutableStateOf("23083000159@student.unmer.ac.id")
    var phone by mutableStateOf("081234567890")
    var address by mutableStateOf("Malang, Jawa Timur")
    var profileImageUri by mutableStateOf<Uri?>(null)

    val hobbies = listOf(
        "Programming",
        "UI/UX Design",
        "Gaming",
        "Exploring New Tech"
    )

    // Academic Data
    val ipk = "3.75"
    val totalSks = "120"
    val semesterAktif = "6"

    val daftarNilai = listOf(
        MataKuliah("IF301", "Pemrograman Mobile", 3, 92, "A"),
        MataKuliah("IF302", "Basis Data", 3, 88, "A"),
        MataKuliah("IF303", "Pemrograman Web", 3, 90, "A"),
        MataKuliah("IF304", "Sistem Operasi", 3, 85, "A-"),
        MataKuliah("IF305", "Jaringan Komputer", 3, 87, "A"),
        MataKuliah("IF306", "Rekayasa Perangkat Lunak", 3, 91, "A")
    )

    fun updateProfile(
        newName: String,
        newNim: String,
        newMajor: String,
        newEmail: String,
        newPhone: String,
        newAddress: String,
        newImageUri: Uri?
    ) {
        name = newName
        nim = newNim
        major = newMajor
        email = newEmail
        phone = newPhone
        address = newAddress
        profileImageUri = newImageUri
    }
}
