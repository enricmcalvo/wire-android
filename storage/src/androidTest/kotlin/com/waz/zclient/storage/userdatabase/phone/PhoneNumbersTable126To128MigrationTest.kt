package com.waz.zclient.storage.userdatabase.phone

import androidx.sqlite.db.SupportSQLiteDatabase
import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_126_TO_127
import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_127_TO_128
import com.waz.zclient.storage.userdatabase.UserDatabaseMigrationTest
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class PhoneNumbersTable126To128MigrationTest : UserDatabaseMigrationTest(126, 128) {

    lateinit var db: SupportSQLiteDatabase

    @Before
    fun setup() {
        db = validateMigration(
            USER_DATABASE_MIGRATION_126_TO_127,
            USER_DATABASE_MIGRATION_127_TO_128
        )
    }

    @Test
    fun givenRoomDbVersionIs126WhenMigratedFrom126To128ThenEnsurePhoneNumbersTableIsDropped() {
        assertFalse(PhoneNumbersTableTestHelper.doesRoomTableExist(db))
    }
}
