package com.deepak.github.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "developers")
data class DeveloperEntity (

    @ColumnInfo(name="username")
    @SerializedName("username")
    var username: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("avatar")
    var avatar: String? = null,

    @PrimaryKey
    @SerializedName("url")
    var url: String

) : Parcelable {
    //region Constructor
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }
    //endregion

    //region Parcelable methods implementation
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(name)
        parcel.writeString(avatar)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DeveloperEntity> = object : Parcelable.Creator<DeveloperEntity> {
            override fun createFromParcel(parcel: Parcel): DeveloperEntity {
                return DeveloperEntity(parcel)
            }

            override fun newArray(size: Int): Array<DeveloperEntity?> {
                return arrayOfNulls(size)
            }
        }
    }
    //endregion
}