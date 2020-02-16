package com.deepak.github.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class RepositoryEntity (

    @ColumnInfo(name="author")
    @SerializedName("author")
    var author: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("avatar")
    var avatar: String? = null,

    @PrimaryKey
    @SerializedName("url")
    var url: String,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("language")
    var language: String? = null,

    @SerializedName("languageColor")
    var languageColor: String? = null,

    @SerializedName("stars")
    var stars: Int = 0,

    @SerializedName("forks")
    var forks: Int = 0,

    @SerializedName("currentPeriodStars")
    var currentPeriodStars: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(name)
        parcel.writeString(avatar)
        parcel.writeString(url)
        parcel.writeString(description)
        parcel.writeString(language)
        parcel.writeString(languageColor)
        parcel.writeInt(stars)
        parcel.writeInt(forks)
        parcel.writeInt(currentPeriodStars)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepositoryEntity> {
        override fun createFromParcel(parcel: Parcel): RepositoryEntity {
            return RepositoryEntity(parcel)
        }

        override fun newArray(size: Int): Array<RepositoryEntity?> {
            return arrayOfNulls(size)
        }
    }
}