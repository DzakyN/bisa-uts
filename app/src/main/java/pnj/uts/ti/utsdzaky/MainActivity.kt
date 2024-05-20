package pnj.uts.ti.utsdzaky

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import pnj.uts.ti.utsdzaky.BeritaFragment
import pnj.uts.ti.utsdzaky.HomeFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.setSelectedItemId(R.id.home)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        val itemId = item.itemId
        if (itemId == R.id.home) {
            fragment = HomeFragment()
        } else if (itemId == R.id.berita) {
            fragment = BeritaFragment()
        } else if (itemId == R.id.profile) {
            fragment = ProfileFragment()
        } else {
            return false
        }
        loadFragment(fragment)
        return true
    }

    private fun loadFragment(fragment: Fragment?) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment!!)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_corner, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_tambah_data) {
            // Ketika menu "Tambah Data" diklik, tampilkan TambahDataFragment ke TambahDatFragment
            val tambahDataFragment = TambahDataFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.tambahdata, tambahDataFragment)
                .addToBackStack(null) // Ini akan menambahkan fragmen ke tumpukan kembali, sehingga dapat dikembalikan dengan tombol kembali
                .commit()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}