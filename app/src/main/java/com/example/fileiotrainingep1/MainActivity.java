package com.example.fileiotrainingep1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.fileiotrainingep1.DBComponents.CakeOrder;
import com.example.fileiotrainingep1.DBComponents.MainViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button selectImage, uploadImage;
    Uri imageUri;
    ImageView img;
    MainViewModel mvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectImage = findViewById(R.id.SelectIMG);
        selectImage.setOnClickListener(this);
        uploadImage = findViewById(R.id.UploadIMG);
        uploadImage.setOnClickListener(this);
        img = findViewById(R.id.DisplayIMAGE);
        mvm = new ViewModelProvider(this).get(MainViewModel.class);
        try {
            mvm.getAllOrders().observe(this, users -> {
                for(CakeOrder u : users){
                    System.out.println(u.getImgUri());
                }
            });
        }
        catch (Exception e){

        }
//        String fileName = "Hello.txt";
//        String s = "Rose";
//        byte[] b = s.getBytes();
//        FileOutputStream fos;
//        try {
//            fos = openFileOutput(fileName, MODE_PRIVATE);
//            fos.write(b);
//            fos.flush();
//            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + fileName, Toast.LENGTH_LONG);
//            fos.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        FileInputStream fis;
//        try {
//            fis = openFileInput(fileName);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//            String line;
//            while((line = br.readLine()) != null){
//                System.out.println(line);
//                System.out.println("Saved to " + getFilesDir() + "/" + fileName);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onClick(View view) {
        if(view == selectImage){
            selectImage();
        }
        if(view == uploadImage){
            uploadImage();
        }
    }

    private void uploadImage() {
        String path = imageUri.toString();
        CakeOrder cakeOrder = new CakeOrder();
        cakeOrder.setImgUri(path);
        cakeOrder.setCustomImage(true);
        mvm.insert(cakeOrder);
        Toast.makeText(this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null){
            return;
        }
        imageUri = data.getData();
        //Insert code to store URI in db
        String path = imageUri.toString();
        img.setImageURI(imageUri);
    }

}
