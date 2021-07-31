package org.kore.kolabnotes.android.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import org.kore.kolabnotes.android.database.entity.Attachment

@Dao
interface AttachmentDao {

    @Insert
    fun insertAll(vararg attachment: Attachment)

    @Delete
    fun delete(attachment: Attachment)
}
