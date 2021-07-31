package org.kore.kolabnotes.android.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import org.kore.kolabnotes.android.database.entity.Note

@Dao
interface NoteDao {

    @Insert
    fun insertAll(vararg notes: Note)

    @Delete
    fun delete(note: Note)
}
