package com.example.usrgam.ejemplo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by USRGAM on 09/05/2018.
 */
class UsuarioParcelable (var nombre: String,
                         var edad: Int,
                         var fechaNacimiento: Date?,
                         var casado: Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.leerFecha(),
            parcel.readByte() != 0.toByte()) {
    }
    fun aumentarunAnio(numero:Int){
        edad += numero
    }

    override fun writeToParcel(destino: Parcel?, flags: Int) {
        destino?.writeString(nombre)
        destino?.writeInt(edad)
        destino?.escribirFecha(fechaNacimiento)
        destino?.writeByte((if (casado) 1 else 0).toByte())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsuarioParcelable> {
        override fun createFromParcel(parcel: Parcel): UsuarioParcelable {
            return UsuarioParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UsuarioParcelable?> {
            return arrayOfNulls(size)
        }
    }

}
fun Parcel.escribirFecha(date: Date?) {
    writeLong(date?.time ?: -1)
}

fun Parcel.leerFecha(): Date? {
    val long = readLong()
    return if (long != -1L) Date(long) else null
}