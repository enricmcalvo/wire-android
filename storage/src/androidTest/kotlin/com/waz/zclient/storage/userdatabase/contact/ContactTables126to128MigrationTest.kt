package com.waz.zclient.storage.userdatabase.contact

import androidx.sqlite.db.SupportSQLiteDatabase
import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_126_TO_127
import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_127_TO_128
import com.waz.zclient.storage.userdatabase.UserDatabaseMigrationTest
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class ContactTables126to128MigrationTest : UserDatabaseMigrationTest(126, 128) {

    lateinit var db: SupportSQLiteDatabase

    @Before
    fun setup() {
        db = validateMigration(
            USER_DATABASE_MIGRATION_126_TO_127,
            USER_DATABASE_MIGRATION_127_TO_128
        )
    }

    @Test
    fun givenRoomDbVersionIs126WhenMigratedFrom127To128ThenEnsureContactsTableIsDropped() {
        assertFalse(ContactsTableTestHelper.doesRoomTableExist(db))
    }

    @Test
    fun givenRoomDbVersionIs126WhenMigratedFrom127To128ThenEnsureContactOnWireTableIsDropped() {
        assertFalse(ContactOnWireTableTestHelper.doesRoomTableExist(db))
    }

    @Test
    fun givenRoomDbVersionIs126WhenMigratedFrom127To128ThenEnsureContactsHashesTableIsDropped() {
        assertFalse(ContactHashesTableTestHelper.doesRoomTableExist(db))
    }
}
