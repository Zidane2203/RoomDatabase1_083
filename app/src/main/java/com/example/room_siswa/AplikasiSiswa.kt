package com.example.room_siswa

import android.app.Application
import com.example.room_siswa.repositori.ContainerApp
import com.example.room_siswa.repositori.ContainerDataApp

class AplikasiSiswa : Application(){
    /**
    * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
    */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}