package com.sudopk.kandroid.dialog

import android.os.Parcel
import android.os.Parcelable

data class ButtonDescription(val id: String, val title: String) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(title)
    }

    private constructor(parcel: Parcel) :
            this(id = parcel.readString()!!,
                    title = parcel.readString()!!)

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ButtonDescription> = object : Parcelable.Creator<ButtonDescription> {
            override fun createFromParcel(parcel: Parcel): ButtonDescription {
                return ButtonDescription(parcel)
            }

            override fun newArray(size: Int): Array<ButtonDescription?> {
                return arrayOfNulls(size)
            }
        }
    }
}
