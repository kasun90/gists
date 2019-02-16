package xyz.justblink.community;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GuavaEventBusTest {
    private static class InitiateProcessing { }
    private static class ProcessingStarted { }
    private static class ProcessingResults { }
    private static class ProcessingFinished { }

    private static EventBus bus = new EventBus();

    @Subscribe
    public void receiveStartRequest(InitiateProcessing evt) {
        System.out.println("Got processing request - starting processing");
        bus.post(new ProcessingStarted());

        System.out.println("Generating results");
        bus.post(new ProcessingResults());
        System.out.println("Generating more results");
        bus.post(new ProcessingResults());

        bus.post(new ProcessingFinished());
    }

    @Subscribe
    public void processingStarted(ProcessingStarted evt) {
        System.out.println("Processing has started");
    }

    @Subscribe
    public void resultsReceived(ProcessingResults evt) {
        System.out.println("got results");
    }

    @Subscribe
    public void processingComplete(ProcessingFinished evt) {
        System.out.println("Processing has completed");
    }


    public static void main(String[] args) {
        GuavaEventBusTest test = new GuavaEventBusTest();
        bus.register(test);
        bus.post(new InitiateProcessing());
        System.out.println("started");
    }
}
