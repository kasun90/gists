package xyz.justblink.community.eventbus;

import xyz.justblink.eventbus.EventBus;

public class Runner {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new PhotoHandler());
        PhotoSaver photoSaver = new PhotoSaver(eventBus);
        photoSaver.download();
    }
}
