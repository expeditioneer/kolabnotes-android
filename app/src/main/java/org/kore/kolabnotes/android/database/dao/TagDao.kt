package org.kore.kolabnotes.android.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import org.kore.kolabnotes.android.database.entity.Tag

@Dao
interface TagDao {

    @Insert
    fun insertAll(vararg tags: Tag)

    @Delete
    fun delete(tag: Tag)
}
