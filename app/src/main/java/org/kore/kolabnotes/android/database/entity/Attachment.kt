package org.kore.kolabnotes.android.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Attachment(
        @PrimaryKey @ColumnInfo(name = "column_id") val columnId: Int,
        val account: String,
        @ColumnInfo(name = "root_folder") val rootFolder: String,
        @ColumnInfo(name = "id_note") val idNote: String,
        @ColumnInfo(name = "id_attachment") val idAttachment: String,
        val creationDate: Int?,
        @ColumnInfo(name = "file_size") val fileSize: String,
        @ColumnInfo(name = "file_name") val fileName: String,
        val mimetype: String
)
