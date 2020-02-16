package com.deepak.github.data.local.entity

import android.arch.persistence.room.Entity
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class RepositoryEntity (

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("avatar")
    var avatar: String? = null,

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
) : Parcelable{
    //region Constructor
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()) {
    }
    //endregion

    //region Parcelable methods implementation
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(name)
        parcel.writeString(avatar)
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

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RepositoryEntity> = object : Parcelable.Creator<RepositoryEntity> {
            override fun createFromParcel(parcel: Parcel): RepositoryEntity {
                return RepositoryEntity(parcel)
            }

            override fun newArray(size: Int): Array<RepositoryEntity?> {
                return arrayOfNulls(size)
            }
        }
    }
    //endregion
}