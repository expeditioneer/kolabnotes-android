package org.kore.kolabnotes.android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.kore.kolabnotes.android.database.dao.AttachmentDao
import org.kore.kolabnotes.android.database.dao.ModificationDao
import org.kore.kolabnotes.android.database.dao.NoteDao
import org.kore.kolabnotes.android.database.dao.TagDao
import org.kore.kolabnotes.android.database.entity.Attachment
import org.kore.kolabnotes.android.database.entity.Modification
import org.kore.kolabnotes.android.database.entity.Note
import org.kore.kolabnotes.android.database.entity.Tag

@Database(entities = [Attachment::class, Modification::class, Note::class, Tag::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun attachmentDao(): AttachmentDao
    abstract fun modificationDao(): ModificationDao
    abstract fun noteDao(): NoteDao
    abstract fun tagDao(): TagDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "kolabNotesDB").build()
                }
            }
            return INSTANCE
        }

        @JvmStatic
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}
