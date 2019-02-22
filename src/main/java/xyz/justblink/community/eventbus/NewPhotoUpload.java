package xyz.justblink.community.eventbus;

public class NewPhotoUpload {
    private String name;

    public NewPhotoUpload(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
