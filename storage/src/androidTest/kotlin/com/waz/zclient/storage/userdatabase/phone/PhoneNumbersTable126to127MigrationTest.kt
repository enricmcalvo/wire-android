package com.waz.zclient.storage.userdatabase.phone

import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_126_TO_127
import com.waz.zclient.storage.userdatabase.UserDatabaseMigrationTest
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PhoneNumbersTable126to127MigrationTest : UserDatabaseMigrationTest(126, 127) {

    @Test
    fun givenPhoneNumberInsertedIntoPhoneNumbersTableVersion126_whenMigratedToVersion127_thenAssertDataIsStillIntact() {

        val contactId = "testContactId"
        val phone = "+49347474746464644"

        PhoneNumbersTableTestHelper.insertPhoneNumber(
            contactId = contactId,
            phone = phone,
            openHelper = testOpenHelper
        )

        val db = validateMigration(USER_DATABASE_MIGRATION_126_TO_127)

        assertTrue(PhoneNumbersTableTestHelper.doesRoomTableExist(db))
    }
}
