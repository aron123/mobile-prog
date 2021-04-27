package hu.arondev.uni.mobileprog.bookmarkapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import hu.arondev.uni.mobileprog.bookmarkapplication.library.LibraryFragment
import hu.arondev.uni.mobileprog.bookmarkapplication.reader.ReaderFragment
import hu.arondev.uni.mobileprog.core.domain.Document
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MainActivityDelegate {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            nav_view.menu.findItem(R.id.nav_library).isChecked = true
            nav_view.menu.performIdentifierAction(R.id.nav_library, 0)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_library -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, LibraryFragment.newInstance())
                .commit()
            R.id.nav_reader -> openDocument(Document.EMPTY)
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun openDocument(document: Document) {
        nav_view.menu.findItem(R.id.nav_reader).isChecked = true
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, ReaderFragment.newInstance(document))
            .commit()
    }
}