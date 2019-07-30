package xyz.justblink.community.grace;

import xyz.justblink.grace.Processor;
import xyz.justblink.grace.render.raw.ExportableTag;
import xyz.justblink.grace.render.raw.ExportableTagRenderer;
import xyz.justblink.grace.tag.Document;

import java.io.File;

public class GraceBeginner {
    public static void main(String[] args) throws Exception {
        Document document = Processor.process(new File("sample.txt"));
        ExportableTagRenderer tagRenderer = ExportableTagRenderer.builder().build();
        ExportableTag exportableTag = tagRenderer.render(document);
    }
}
