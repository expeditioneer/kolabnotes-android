package org.kore.kolabnotes.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
        @PrimaryKey @ColumnInfo(name = "column_id") val columnId: Int,
        val account: String,
        @ColumnInfo(name = "root_folder") val rootFolder: String,
        val discriminator: String,
        val uid: String,
        val productId: String,
        val creationDate: Int?,
        val modificationDate: Int?,                                             //milliseconds
        val classification: String?,
        @ColumnInfo(name = "uid_notebook") val uidNotebook: String?,
        val color: String?,
        val summary: String,
        val shared: String,                                                     //false or true
        @ColumnInfo(name = "column_info") val modificationAllowed: String?,     //false or true
        @ColumnInfo(name = "creation_allowed") val creationAllowed: String?,    //false or true
        val description: String?
)
