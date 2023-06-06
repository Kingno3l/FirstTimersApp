package android.example.firsttimersapp.infrastructure.database

import android.example.firsttimersapp.domain.FirstTimer
import android.example.firsttimersapp.infrastructure.dao.FirstTimerDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FirstTimer::class],
    version = 1
)
abstract class FirstTimerDatabase: RoomDatabase() {

    abstract val dao: FirstTimerDao
}