package com.waz.zclient.storage.userdatabase

import androidx.sqlite.db.SupportSQLiteDatabase

class RoomDbTestHelper private constructor() {

    companion object {
        fun doesTableExist(db: SupportSQLiteDatabase, tableName: String): Boolean {
            val c = db.query("select DISTINCT tbl_name from sqlite_master where tbl_name = '$tableName'")
            val tableCount = c.count
            c.close()
            return tableCount > 0
        }
    }

}
