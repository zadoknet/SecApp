package zadok.jct.SecApp.UI;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import zadok.jct.SecApp.R;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    public void onCreate(Bundle saveeIntanceState) {
        super.onCreate(saveeIntanceState);
        setContentView(R.layout.activity_main);
        dl=(DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.Close)
        {

        public void onDrawerClosed (View view)
        {
            getSupportActionBar().setTitle("Close");
            supportInvalidateOptionsMenu();
        }


        public void onDrawerOpened(View drawerView) {
            getSupportActionBar().setTitle("Open");//set title of action bar
            // calling onPrepareOptionsMenu() to hide action bar icons
            supportInvalidateOptionsMenu();
        }};


        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.orders:
                        loadFragment(new FriendsParcelsFragment());
                        return true;
                    case R.id.ended:
                        loadFragment(new RegisteredParcelsFragment());
                        return true;
                    case R.id.exit:
                        finish();
                        System.exit(0);
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    private void loadFragment(Fragment fragment) {
        dl.closeDrawer(nv);
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }


    public MainActivity()
        {
            super();
        }

}
