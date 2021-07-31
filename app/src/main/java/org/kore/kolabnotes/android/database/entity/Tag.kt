package org.kore.kolabnotes.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag (
        @PrimaryKey @ColumnInfo(name = "column_id") val columnId: Int,
        val account: String,
        @ColumnInfo(name = "root_folder") val rootFolder: String,
        val uid: String,
        @ColumnInfo(name = "tag_uid") val tagUid: String,
        @ColumnInfo(name = "product_id") val productID: String,
        val creationDate: Int?,
        val modificationDate: Int?,                                             //milliseconds
        val color: String?,
        val priority: Int?,
        val tagname: String
)
