package com.test.table.dessertclicker;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.test.table.dessertclicker.databinding.ActivityMainBinding;
import com.test.table.dessertclicker.databinding.ActivityMainBinding;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private int revenue=0;
    private int dessertsSold=0;
    private ActivityMainBinding binding;
    private LinkedList<Dessert> dessertList=new LinkedList<>();
    private Dessert currentDessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.i("onCreate called");
        //setContentView(R.layout.activity_main);


        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        initialView();
        createDessertList();
    }
    public void initialView(){
        binding.dessertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onDessertClicked();
            }
        });

    }

    private void onDessertClicked() {
        // Update the score
        revenue += currentDessert.getPrice();
        Timber.i("revenue= "+revenue);
        String revString= revenue+"";
        dessertsSold++;
        Timber.i("dessertsSold= "+dessertsSold);
        String desString=dessertsSold+"";
        binding.revenueText.setText(revString);
        binding.amountSoldText.setText(desString);
        // Show the next dessert
        showCurrentDessert();
    }

    private void showCurrentDessert() {
        Dessert newDessert = dessertList.get(0);
//        int prevDessert=0;
//        int i=0;
//        while(dessertsSold>newDessert.getProductionAmount()){
//            newDessert=dessertList.get(i++);
//            if(i>0){
//
//            }
//
//        }
        for (Dessert dessert : dessertList) {
            if (dessertsSold >= dessert.getProductionAmount()) {
                newDessert = dessert;
            }
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            else{
                break;
            }
        }
        // If the new dessert is actually different than the current dessert, update the image
        if (newDessert != currentDessert) {
            Timber.i("new Dessert is %s", newDessert.getPrice());
            currentDessert = newDessert;
            binding.dessertButton.setImageResource(newDessert.getImageId());
        }
    }

    public void createDessertList(){
        Dessert dessertCupcake=new Dessert(R.drawable.ic_cupcake,5,0);
        Dessert dessertDonut=new Dessert(R.drawable.ic_donut,10,5);
        Dessert dessertJellybean=new Dessert(R.drawable.ic_jellybean,1000,1000);

        dessertList.add(dessertCupcake);
        dessertList.add(dessertDonut);
        dessertList.add(dessertJellybean);

        currentDessert=dessertList.get(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shareMenuButton) {
            onShare();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onShare() {

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText(getString(R.string.share_text, dessertsSold, revenue))
                .setType("text/plain")
                .getIntent();

        try {

            startActivity(shareIntent);

        } catch (ActivityNotFoundException ANFE) {

            Toast.makeText(this, getString(R.string.sharing_not_available),

                    Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.i("on Start method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("onResume method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("onPause method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("onStop method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy method called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.i("onRestart method called");
    }
}
