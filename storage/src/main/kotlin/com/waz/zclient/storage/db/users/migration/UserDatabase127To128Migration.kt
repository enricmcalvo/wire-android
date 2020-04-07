package com.waz.zclient.storage.db.users.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

private const val START_VERSION = 127
private const val END_VERSION = 128

val USER_DATABASE_MIGRATION_127_TO_128 = object : Migration(START_VERSION, END_VERSION) {

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
