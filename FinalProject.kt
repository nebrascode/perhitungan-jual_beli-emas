
import java.util.Scanner
import kotlin.Exception

abstract class Emas{ //superclass abstract
   open protected val beli=850000 //modifier PROTECTED
    open protected val jual=900000 //modifier PROTECTED
    abstract fun npwp() //function yang diwariskan/diturunkan dgn metode abstract
    abstract fun nonNpwp() //function yang diwariskan/diturunkan dgn metode abstract
}
//==============BELI EMAS================
class Beli: Emas(){ //sub class dari superclass:Emas ----PUBLIC VISIBILITY-----
    override fun npwp(){ //turunan function ------POLIMORPHISM (OVERRIDE)------
        println("Harga emas = Rp. $beli") //tampilan harga adalah hasil dari memanggil variabel dari modifier dalam superclass
        val reader = Scanner(System.`in`)
        print("Jumlah beli (gram) : ")
        val jumlah:Double=reader.nextDouble() //untuk inputan user, tipe data : double

        // CONTROL FLOW >> percabangan IF-ELSE-IF
        if (jumlah <0.5){
           print("Maaf jumlah (gram) belum mencapai batas minimal")
            return
        }
        else if (jumlah>80.0){
            print("Maaf jumlah (gram) melebihi batas maksimal")
            return
        }
        else{
            val totalHrg=beli*jumlah //membuat variabel untuk menghitung total harga dikali jumlah
            val totalHarga=totalHrg.toLong()    //tipe data hasil dari perhitungan harga*jumlah diubah menjadi Long
            val pajak=(totalHarga*45)/10000
            val total = totalHarga - pajak // var utk menghitung total keseluruhan  (harga dikurangi dengan pajak)
            println("----------------------------------")
            println("               NOTA               ")
            println("----------------------------------")
            println("Total Harga       = Rp   $totalHarga ")
            println("Pajak 0.45%       = Rp   $pajak      ")
            println("Total pembayaran  = Rp   $total      ")

        }

    }
    override fun nonNpwp(){ //turunan dari function ------POLIMORPHISM (OVERRIDE)------
        println("Harga emas = Rp. $beli") //tampilan harga adalah hasil dari memanggil variabel dari modifier dalam superclass
        val reader = Scanner(System.`in`)
        print("Jumlah beli (gram) : ")
        val jumlah:Double=reader.nextDouble() //untuk inputan user, tipe data : double
// CONTROL FLOW >> percabangan IF-ELSE-IF
        if (jumlah <0.5){
            print("Maaf jumlah (gram) belum mencapai batas minimal")
        }
        else if (jumlah>80){
            print("Maaf jumlah (gram) melebihi batas maksimal")
        }
        else{
            val totalHrg=beli*jumlah //membuat variabel untuk menghitung total harga dikali jumlah
            val totalHarga=totalHrg.toLong() //tipe data hasil dari perhitungan harga*jumlah diubah menjadi Long
            val pajak=(totalHarga*9)/1000
            val total = totalHarga - pajak
            println("----------------------------------")
            println("               NOTA               ")
            println("----------------------------------")
            println("Total Harga      = Rp   $totalHarga ")
            println("Pajak 0.9%       = Rp   $pajak      ")
            println("Total pembayaran = Rp   $total      ")
        }
    }
}
//====================JUAL EMAS===================
class Jual:Emas(){          //subclass turunan dari class:Emas ----PUBLIC VISIBILITY-----
    override fun npwp(){        //turunan dari function ------POLIMORPHISM (OVERRIDE)------
        println("Harga emas = Rp. $jual") //tampilan harga adalah hasil dari memanggil variabel dari modifier dalam superclass
        val reader = Scanner(System.`in`)
        print("Jumlah beli (gram) : ")
        val jumlah:Double=reader.nextDouble()//untuk inputan user, tipe data : double



// CONTROL FLOW >> percabangan IF-ELSE-IF
            if (jumlah <1){
                print("Maaf jumlah (gram) belum mencapai batas minimal")
                return
            }
            else if (jumlah>100){
                print("Maaf jumlah (gram) melebihi batas maksimal")
                return
            }
            else{
                val totalHrg=jual*jumlah    //membuat variabel untuk menghitung total harga dikali jumlah
                val totalHarga=totalHrg.toLong()   //tipe data hasil dari perhitungan harga*jumlah diubah menjadi Long
                val pajak=(totalHarga*15)/1000
                val total = totalHarga - pajak
                println("----------------------------------")
                println("               NOTA               ")
                println("----------------------------------")
                println("Total Harga      = Rp   $totalHarga ")
                println("Pajak 1.5%       = Rp   $pajak      ")
                println("Total pembayaran = Rp   $total      ")
            }
    }
    override fun nonNpwp(){         //turunan dari function ------POLIMORPHISM (OVERRIDE)------
        println("Harga emas = Rp. $jual") //tampilan harga adalah hasil dari memanggil variabel dari modifier dalam superclass
        val reader = Scanner(System.`in`)
        print("Jumlah beli (gram) : ")
        val jumlah:Double=reader.nextDouble()
        if (jumlah <1){
            print("Maaf jumlah (gram) belum mencapai batas minimal")
            return
        }
        else if (jumlah>100){
            print("Maaf jumlah (gram) melebihi batas maksimal")
            return
        }
        else{
            val totalHrg=jual*jumlah        //membuat variabel untuk menghitung total harga dikali jumlah
            val totalHarga=totalHrg.toLong()    //tipe data hasil dari perhitungan harga*jumlah diubah menjadi Long
            val pajak=(totalHarga*3)/100
            val total = totalHarga - pajak
            println("----------------------------------")
            println("               NOTA               ")
            println("----------------------------------")
            println("Total Harga      = Rp   $totalHarga ")
            println("Pajak 3%         = Rp   $pajak      ")
            println("Total pembayaran = Rp   $total      ")
        }
    }
}

fun main (){
    println("==========================================")
    println("         PROGRAM JUAL BELI EMAS           ")
    println("==========================================")
    println("Pilihan : ")
    println("1. Beli Emas")
    println("2. Jual Emas")

    try {               //---UNCHECKED EXCEPTION===
        val reader = Scanner(System.`in`)
        print("Masukkan pilihan :  ")
        val pilihan:Int=reader.nextInt() //variabel untuk menyimpan hasil inputan user

        if (pilihan==1) { //jika pilihan user itu angka 1
            print("Apakah memiliki NPWP? [y/n] : ")
            val punya = readLine()
            if (punya == "y" || punya == "Y") { //jika pilihan user punya NPWP
                var beli: Emas = Beli() // variabel untuk memanggil class
                beli.npwp() //memanggil function dalam kelas yg dipanggil
            } else if (punya == "n" || punya == "N") { //jika pilihan user tidak punya NPWP
                var beli: Emas = Beli() // variabel untuk memanggil class
                beli.nonNpwp()  //memanggil function dalam kelas yg dipanggil
            } else { //jika inputan user tidak memenuhi kondisi maka akan ada tampilan ini
                print("Maaf, pilihan salah")
            }
        }
        else if (pilihan==2){   //jika pilihan user itu angka 2
            print("Apakah memiliki NPWP? [y/n] : ")
            val punya = readLine()
            if  (punya == "y" || punya == "Y") {
                var jual: Emas = Jual()
                jual.npwp()
            } else if (punya == "n" || punya == "N") {
                var jual: Emas = Jual()
                jual.nonNpwp()
            } else {
                print("Maaf, pilihan salah")
            }
        }
        else throw Exception("Pilihan tidak tersedia. Silahkan input angka [1] atau [2]") // keluar dari bagan try
    }
    catch (e: NumberFormatException) {
        // jika tipe data angka, tetapi user menginputkan yang lain
        // maka program akan langsungn berhenti dan muncul pesan di bawah ini
        println("Nilai yang anda inputkan tidak sesuai!")
    } catch (e: Exception) {
        // throw Exception yang ditulis di fungsi pada class akan muncul di bawah ini
        println(e.message)
    }


}

