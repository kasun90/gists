package xyz.justblink.community.eventbus;

import xyz.justblink.eventbus.EventBus;

public class PhotoSaver {
    private EventBus eventBus;

    public PhotoSaver(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void download() {
        String photoName = "sample.jpg";

        // the code to download the photo goes here

        eventBus.post(new NewPhotoUpload(photoName));
    }
}
