package xyz.justblink.community;

import xyz.justblink.eventbus.Dispatcher;
import xyz.justblink.eventbus.EventBus;
import xyz.justblink.eventbus.Subscribe;

public class BlinkrEventBusTest {
    private static class InitiateProcessing { }
    private static class ProcessingStarted { }
    private static class ProcessingResults { }
    private static class ProcessingFinished { }

    private static EventBus bus = new EventBus(Dispatcher.immediateDispatcher());

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
        BlinkrEventBusTest test = new BlinkrEventBusTest();
        bus.register(test);
        bus.post(new InitiateProcessing());
        System.out.println("started");
    }
}
