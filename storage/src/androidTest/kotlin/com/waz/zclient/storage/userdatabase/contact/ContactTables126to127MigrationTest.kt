package com.waz.zclient.storage.userdatabase.contact

import com.waz.zclient.storage.db.users.migration.USER_DATABASE_MIGRATION_126_TO_127
import com.waz.zclient.storage.userdatabase.UserDatabaseMigrationTest
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ContactTables126to127MigrationTest : UserDatabaseMigrationTest(126, 127) {

    @Test
    fun givenContactInsertedIntoContactsTableVersion126_whenMigratedToVersion127_thenAssertDataIsStillIntact() {

        val id = "testId"
        val name = "testName"
        val nameType = 1
        val sortKey = "testSortKey"
        val searchKey = "testSearchKey"

        ContactsTableTestHelper.insertContact(
            id = id,
            name = name,
            nameType = nameType,
            sortKey = sortKey,
            searchKey = searchKey,
            openHelper = testOpenHelper)

        val db = validateMigration(USER_DATABASE_MIGRATION_126_TO_127)

        assertTrue(ContactsTableTestHelper.doesRoomTableExist(db))
    }

    @Test
    fun givenContactOnWireInsertedIntoContactOnWireTableVersion126_whenMigratedToVersion127_thenAssertDataIsStillIntact() {

        val userId = "testUserId"
        val contactId = "testContactId"

        ContactOnWireTableTestHelper.insertContactOnWire(
            userId = userId,
            contactId = contactId,
            openHelper = testOpenHelper
        )

        val db = validateMigration(USER_DATABASE_MIGRATION_126_TO_127)

        assertTrue(ContactOnWireTableTestHelper.doesRoomTableExist(db))
    }

    @Test
    fun givenContactHashInsertedIntoContactHashesTableVersion126_whenMigratedToVersion127_thenAssertDataIsStillIntact() {

        val id = "testId"
        val hashes = "testHashes"

        ContactHashesTableTestHelper.insertContactHashes(
            id = id,
            hashes = hashes,
            openHelper = testOpenHelper
        )

        val db = validateMigration(USER_DATABASE_MIGRATION_126_TO_127)

        runBlocking {
            assertTrue(ContactHashesTableTestHelper.doesRoomTableExist(db))
        }
    }
}
