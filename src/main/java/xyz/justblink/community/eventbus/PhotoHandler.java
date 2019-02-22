package xyz.justblink.community.eventbus;

import xyz.justblink.eventbus.Subscribe;

public class PhotoHandler {

    @Subscribe
    public void onNewPhoto(NewPhotoUpload event) {
        System.out.println("New photo upload event received: name=" + event.getName());
    }
}
