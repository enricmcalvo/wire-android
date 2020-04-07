package com.waz.zclient.storage.userdatabase.phone

import android.content.ContentValues
import androidx.sqlite.db.SupportSQLiteDatabase
import com.waz.zclient.storage.DbSQLiteOpenHelper
import com.waz.zclient.storage.userdatabase.RoomDbTestHelper


class PhoneNumbersTableTestHelper private constructor() {

    companion object {

        private const val PHONE_NUMBERS_TABLE_NAME = "PhoneNumbers"
        private const val PHONE_NUMBERS_ID_COL = "contact"
        private const val PHONE_NUMBERS_PHONE_COL = "phone_number"

        fun insertPhoneNumber(contactId: String, phone: String, openHelper: DbSQLiteOpenHelper) {

            val contentValues = ContentValues().also {
                it.put(PHONE_NUMBERS_ID_COL, contactId)
                it.put(PHONE_NUMBERS_PHONE_COL, phone)
            }
            openHelper.insertWithOnConflict(
                tableName = PHONE_NUMBERS_TABLE_NAME,
                contentValues = contentValues
            )
        }

        fun doesRoomTableExist(db: SupportSQLiteDatabase): Boolean =
            RoomDbTestHelper.doesTableExist(db, PHONE_NUMBERS_TABLE_NAME)
    }
}
