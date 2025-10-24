# 🏆 **Klub Vfl Wolfsburg**

**Nama**: Andhika Putra Restu Ilahi

**NIM**: H1D023089

**Shift Baru**: Shift A

**Shift Lama**: Shift F

---

## 🎥 **Video Demo Aplikasi**

https://github.com/user-attachments/assets/610c6f6b-5945-4b2f-95fb-60bc45c90b26

---

## 🔄 **Alur Data: Dari Pemanggilan API hingga Penyajian di Layar**

Berikut penjelasan alur data yang terjadi di dalam aplikasi:

1. **Konfigurasi API**
   - RetrofitInstance mengatur koneksi ke API Football-Data.org dengan base URL https://api.football-data.org/v4/
   - ApiService mendefinisikan endpoint getTeamById() dengan autentikasi menggunakan X-Auth-Token

2. **Model Data**
   - TeamResponse berisi struktur data yang diterima dari API:
        1. Coach: Data pelatih (nama, tanggal lahir, kebangsaan)
        2. Player: Data pemain (nama, posisi, tanggal lahir, kebangsaan)
   - Menggunakan anotasi @SerializedName untuk mapping JSON ke objek Kotlin

3. **Pemanggilan API**
   - Untuk Head Coach (HeadCoachActivity):
      1. Activity menerima TEAM_ID dari MainActivity
      2. Memanggil RetrofitInstance.api.getTeamById(teamId) secara asynchronous
      3. Callback onResponse() menerima data dan mengekstrak objek coach
      4. Data coach langsung ditampilkan ke TextView (nama, tanggal lahir, kebangsaan)
   - Untuk Squad (TeamSquadActivity):
      1. Activity menerima TEAM_ID dari MainActivity
      2. Memanggil RetrofitInstance.api.getTeamById(teamId) secara asynchronous
      3. Callback onResponse() menerima data dan mengekstrak list squad
      4. List squad dikirim ke PlayerAdapter

4. **Adapter dan RecyclerView**
   - PlayerAdapter menerima list player dari TeamSquadActivity
   - Setiap item player di-bind ke ViewHolder:
      - Menampilkan nama dan kebangsaan pemain
      - Memberikan warna background berdasarkan posisi:
         - Kuning: Goalkeeper
         - Biru: Defence (Right-Back, Centre-Back, Left-Back)
         - Hijau: Midfield (Left, Defensive, Attacking, Central)
         - Merah: Offence (Centre-Forward, Right Winger)
   - Mengatur click listener untuk membuka bottom sheet detail player

5. **Error Handling**
   - Setiap pemanggilan API dilengkapi dengan:
      - onFailure(): Menangani kegagalan koneksi
      - Toast message: Memberikan feedback ke user
      - Logging: Mencatat error untuk debugging
