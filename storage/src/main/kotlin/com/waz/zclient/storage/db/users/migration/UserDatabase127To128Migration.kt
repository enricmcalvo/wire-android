package com.waz.zclient.storage.db.users.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val USER_DATABASE_MIGRATION_127_TO_128 = object : Migration(127, 128) {

    override fun migrate(database: SupportSQLiteDatabase) {
        dropContactTables(database)
    }

    private fun dropContactTables(database: SupportSQLiteDatabase) {
        database.execSQL("DROP TABLE IF EXISTS ContactHashes")
        database.execSQL("DROP TABLE IF EXISTS Contacts")
        database.execSQL("DROP TABLE IF EXISTS ContactsOnWire")
        database.execSQL("DROP TABLE IF EXISTS PhoneNumbers")
        database.execSQL("DROP TABLE IF EXISTS EmailAddresses")
    }
}
