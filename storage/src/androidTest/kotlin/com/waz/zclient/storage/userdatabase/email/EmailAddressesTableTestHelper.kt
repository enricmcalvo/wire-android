package com.waz.zclient.storage.userdatabase.email

import android.content.ContentValues
import androidx.sqlite.db.SupportSQLiteDatabase
import com.waz.zclient.storage.DbSQLiteOpenHelper
import com.waz.zclient.storage.userdatabase.RoomDbTestHelper
import com.waz.zclient.storage.userdatabase.contact.ContactOnWireTableTestHelper


class EmailAddressesTableTestHelper private constructor() {

    companion object {

        private const val EMAIL_ADDRESSES_TABLE_NAME = "EmailAddresses"
        private const val EMAIL_ADDRESSES_CONTACT_ID_COL = "contact"
        private const val EMAIL_ADDRESSES_EMAIL_COL = "email_address"

        fun insertEmailAddress(contactId: String, email: String, openHelper: DbSQLiteOpenHelper) {

            val contentValues = ContentValues().also {
                it.put(EMAIL_ADDRESSES_CONTACT_ID_COL, contactId)
                it.put(EMAIL_ADDRESSES_EMAIL_COL, email)
            }
            openHelper.insertWithOnConflict(
                tableName = EMAIL_ADDRESSES_TABLE_NAME,
                contentValues = contentValues
            )
        }

        fun doesRoomTableExist(db: SupportSQLiteDatabase): Boolean =
            RoomDbTestHelper.doesTableExist(db, EMAIL_ADDRESSES_TABLE_NAME)
    }
}
