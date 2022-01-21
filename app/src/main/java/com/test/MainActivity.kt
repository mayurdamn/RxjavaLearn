package com.test

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var stringInput: String =""
    var noofRailss :Int =3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //railFence( stringInput, noofRailss )
        var clearcache = findViewById<TextView>(R.id.clearcache)
        clearcache.setOnClickListener {
            try {
                val dir: File = getCacheDir()
                var isDele =deleteDir(dir)
                if(isDele){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        super.finishAndRemoveTask();
                    }
                    else {
                        super.finish();
                    }
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun deleteDir(dir: File) :Boolean {

        return if (dir != null && dir.isDirectory) {
            val children = dir.list()
            for (i in children.indices) {
                val success: Boolean = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
            dir.delete()
        } else if (dir != null && dir.isFile) {
            dir.delete()
        } else {
            false
        }
    }

    private fun railFence(stringInput: String, noofRails: Int) {
        getDecryptedData(stringInput,noofRails)
        getEncryptedData(stringInput,noofRails)
    }


    fun getDecryptedData(data: String, noofRails: Int): String? {
        val decrypted = CharArray(data.length)
        var n = 0
        for (k in 0 until noofRails) {
            var index = k
            var down = true
            while (index < data.length) {
                //System.out.println(k + " " + index+ " "+ n );
                decrypted[index] = data[n++]
                if (k == 0 || k == noofRails - 1) {
                    index = index + 2 * (noofRails - 1)
                } else if (down) {
                    index = index + 2 * (noofRails - k - 1)
                    down = !down
                } else {
                    index = index + 2 * k
                    down = !down
                }
            }
        }
        return String(decrypted)
    }


    fun getEncryptedData(data: String, noofRails: Int): String? {
        val encrypted = CharArray(data.length)
        var n = 0
        for (k in 0 until noofRails) {
            var index = k
            var down = true
            while (index < data.length) {
                //System.out.println(k + " " + index+ " "+ n );
                encrypted[n++] = data[index]
                if (k == 0 || k == noofRails - 1) {
                    index = index + 2 * (noofRails - 1)
                } else if (down) {
                    index = index + 2 * (noofRails - k - 1)
                    down = !down
                } else {
                    index = index + 2 * k
                    down = !down
                }
            }
        }
        return String(encrypted)
    }

    //alternate way not efficient
    fun getEncryptedData2(data: String,noofRails: Int): String? {
        val len = data.length
        val sb = arrayOfNulls<StringBuffer>(noofRails)
        for (i in 0 until noofRails) {
            sb[i] = StringBuffer()
        }
        var index = 0
        var direction = 1
        for (i in 0 until data.length) {
            sb[index]!!.append(data[i])
            index = index + direction
            if (index == 0) {
                direction = 1
            } else if (index == noofRails) {
                if (index == 2) { // base case for cipher of length 2
                    index = 0
                } else {
                    direction = -1
                    index = noofRails - 2
                }
            }
        }
        for (i in 1 until noofRails) {
            sb[0]!!.append(sb[i].toString())
        }
        return sb[0].toString()
    }


    fun encryption(str: String, rails: Int) {
        var checkdown = false //check whether it is moving downward or upward
        var j = 0
        val col = str.length //column length is the size of string
        val a = Array(
            rails // no of row is the no of rails entered by user
        ) {
            CharArray(
                col
            )
        }
        //we create a matrix of a of row *col size
        for (i in 0 until col) {  //matrix visitin in rails order and putting the character of plaintext
            if (j == 0 || j == rails // no of row is the no of rails entered by user
                - 1
            ) checkdown = !checkdown
            a[j][i] = str[i]
            if (checkdown) {
                j++
            } else j--
        }

        //visiting the matrix in usual order to get ciphertext
        for (i in 0 until rails // no of row is the no of rails entered by user
        ) {
            for (k in 0 until col) {
                print(a[i][k].toString() + "  ")
            }
            println()
        }
        var en = ""
        println("----------------------")
        for (i in 0 until rails // no of row is the no of rails entered by user
        ) {
            for (k in 0 until col) {
                if (a[i][k] != 0.toChar()) en = en + a[i][k]
            }
        }
        println(en) //printing the ciphertext
    }
}