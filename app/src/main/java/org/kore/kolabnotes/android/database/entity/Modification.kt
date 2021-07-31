package org.kore.kolabnotes.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Modification(
    @PrimaryKey @ColumnInfo(name = "column_id") val columnId: Int,
    val account: String,
    @ColumnInfo(name = "root_folder") val rootFolder: String,
    val uid: String,
    @ColumnInfo(name = "uid_notebook") val uidNotebook: String?,
    val discriminator: String?,
    val modificationDate: Int?,                                             //milliseconds
    val modificationType: String
)
