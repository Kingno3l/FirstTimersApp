package android.example.firsttimersapp.infrastructure.dao

import android.example.firsttimersapp.domain.FirstTimer
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface FirstTimerDao {

    @Upsert
    suspend fun upsertFirstTimer(firstTimer: FirstTimer)

    @Delete
    suspend fun deleteFirstTimer(firstTimer: FirstTimer)


}