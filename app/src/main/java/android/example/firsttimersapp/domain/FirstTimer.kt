package android.example.firsttimersapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FirstTimer(
    val fullName : String,
    val phoneNumber : String,
    val email : String,
    val address : String,
    val prayerRequest : String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
