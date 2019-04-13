package com.example.streakr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.snapchat.kit.sdk.SnapCreative;
import com.snapchat.kit.sdk.creative.api.SnapCreativeKitApi;
import com.snapchat.kit.sdk.creative.exceptions.SnapMediaSizeException;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory;
import com.snapchat.kit.sdk.creative.media.SnapPhotoFile;
import com.snapchat.kit.sdk.creative.models.SnapPhotoContent;

import java.io.File;

import pl.aprilapps.easyphotopicker.EasyImage;

public class MainActivity extends AppCompatActivity {
    SnapCreativeKitApi snapCreativeKitApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        snapCreativeKitApi = SnapCreative.getApi(this);
        SnapMediaFactory snapMediaFactory = SnapCreative.getMediaFactory(this);
        File lion = new File("lion.png");
        try {
            SnapPhotoFile photo = snapMediaFactory.getSnapPhotoFromFile(lion);
            SnapPhotoContent snapPhotoContent = new SnapPhotoContent(photo);
            snapCreativeKitApi.send(snapPhotoContent);
        } catch (SnapMediaSizeException e) {
            e.printStackTrace();
        }
    }
}
