package com.rury.profilemahasiswa

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
    var name by mutableStateOf("M.Yana Mabruri")
    var nim by mutableStateOf("23083000128")
    var bio by mutableStateOf("Information Systems student exploring the world of mobile app development and data analysis.")
    var major by mutableStateOf("Sistem Informasi")
    var email by mutableStateOf("rury@student.unmer.ac.id")
    var phone by mutableStateOf("089876543210")
    var address by mutableStateOf("Malang, Indonesia")
    var profileImageUri by mutableStateOf<Uri?>(null)

    val hobbies = listOf(
        "Mobile Development",
        "Photography",
        "Music",
        "Travel"
    )

    // Academic Data
    val ipk = "3.80"
    val totalSks = "124"
    val semesterAktif = "6"

    val daftarNilai = listOf(
        MataKuliah("IF301", "Pemrograman Mobile", 3, 95, "A"),
        MataKuliah("IF302", "Basis Data", 3, 90, "A"),
        MataKuliah("IF303", "Pemrograman Web", 3, 92, "A"),
        MataKuliah("IF304", "Sistem Operasi", 3, 88, "A"),
        MataKuliah("IF305", "Jaringan Komputer", 3, 89, "A"),
        MataKuliah("IF306", "Rekayasa Perangkat Lunak", 3, 93, "A")
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
