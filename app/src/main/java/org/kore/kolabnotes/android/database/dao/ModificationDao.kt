package org.kore.kolabnotes.android.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import org.kore.kolabnotes.android.database.entity.Modification

@Dao
interface ModificationDao {

    @Insert
    fun insertAll(vararg modification: Modification)

    @Delete
    fun delete(modification: Modification)
}
