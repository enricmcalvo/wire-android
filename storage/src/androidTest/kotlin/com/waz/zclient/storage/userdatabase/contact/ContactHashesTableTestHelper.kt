package com.waz.zclient.storage.userdatabase.contact

import android.content.ContentValues
import androidx.sqlite.db.SupportSQLiteDatabase
import com.waz.zclient.storage.DbSQLiteOpenHelper
import com.waz.zclient.storage.userdatabase.RoomDbTestHelper


class ContactHashesTableTestHelper private constructor() {

    companion object {

        private const val CONTACT_HASHES_TABLE_NAME = "ContactHashes"
        private const val CONTACT_HASHES_ID_COL = "_id"
        private const val CONTACT_HASHES_HASHES_COL = "hashes"

        fun insertContactHashes(id: String, hashes: String, openHelper: DbSQLiteOpenHelper) {

            val contentValues = ContentValues().also {
                it.put(CONTACT_HASHES_ID_COL, id)
                it.put(CONTACT_HASHES_HASHES_COL, hashes)
            }

            openHelper.insertWithOnConflict(
                tableName = CONTACT_HASHES_TABLE_NAME,
                contentValues = contentValues
            )
        }

        fun doesRoomTableExist(db: SupportSQLiteDatabase): Boolean =
            RoomDbTestHelper.doesTableExist(db, CONTACT_HASHES_TABLE_NAME)
    }
}
