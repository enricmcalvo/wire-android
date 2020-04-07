package com.waz.zclient.storage.db.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CacheEntry")
data class CacheEntryEntity(
    @PrimaryKey
    @ColumnInfo(name = "key")
    val key: String,

    @ColumnInfo(name = "file")
    val fileId: String,

    @ColumnInfo(name = "data", typeAffinity = ColumnInfo.BLOB)
    val data: ByteArray?,

    @ColumnInfo(name = "lastUsed")
    val lastUsed: Long,

    @ColumnInfo(name = "timeout")
    val timeout: Long,

    @ColumnInfo(name = "path")
    val filePath: String?,

    @ColumnInfo(name = "file_name")
    val fileName: String?,

    @ColumnInfo(name = "mime")
    val mime: String,

    @ColumnInfo(name = "enc_key")
    val encKey: String?,

    @ColumnInfo(name = "length")
    val length: Long?
)
