package com.example.room_siswa.repositori

import com.example.room_siswa.room.Siswa
import com.example.room_siswa.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}
class OfflineRepositoriSiswa(private val siswaDao: SiswaDao): RepositoriSiswa
{
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}