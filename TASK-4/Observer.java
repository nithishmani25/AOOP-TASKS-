import java.util.ArrayList;
import java.util.List;

// Observer interface
public interface Observer {
    void update(String event);
}

// Bidder class implementing the Observer interface
public class Bidder implements Observer {
    private String name;

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println("Bidder " + name + " received notification: " + event);
    }

    public String getName() {
        return name;
    }
}

// Abstract Auction class
public abstract class Auction {
    private List<Observer> bidders = new ArrayList<>();

    public void subscribe(Observer bidder) {
        bidders.add(bidder);
    }

    public void unsubscribe(Observer bidder) {
        bidders.remove(bidder);
    }

    public void notifyBidders(String event) {
        for (Observer bidder : bidders) {
            bidder.update(event);
        }
    }

    public abstract void startAuction();
    public abstract void placeBid();
    public abstract void endAuction();
}

// Template class for Auctions
public abstract class AuctionTemp extends Auction {
    public final void conductAuction() {
        startAuction();
        placeBid();
        endAuction();
    }
}

// ReserveAuction class
public class ReserveAuction extends AuctionTemp {
    private double reservePrice;

    public ReserveAuction(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    @Override
    public void startAuction() {
        System.out.println("Starting reserve auction with a reserve price of " + reservePrice + "...");
        notifyBidders("Reserve auction has started! Reserve price is " + reservePrice);
    }

    @Override
    public void placeBid() {
        System.out.println("Placing a bid in the reserve auction.");
        notifyBidders("A new bid has been placed in the reserve auction.");
    }

    @Override
    public void endAuction() {
        System.out.println("Ending reserve auction.");
        notifyBidders("Reserve auction has ended!");
    }
}

// StandardAuction class
public class StandardAuction extends AuctionTemp {
    @Override
    public void startAuction() {
        System.out.println("Starting standard auction...");
        notifyBidders("Standard auction has started!");
    }

    @Override
    public void placeBid() {
        System.out.println("Placing a bid in the standard auction.");
        notifyBidders("A new bid has been placed in the standard auction.");
    }

    @Override
    public void endAuction() {
        System.out.println("Ending standard auction.");
        notifyBidders("Standard auction has ended!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        Auction standardAuction = new StandardAuction(); // Use Auction reference
        Auction reserveAuction = new ReserveAuction(1000.0); // Use Auction reference

        standardAuction.subscribe(bidder1); // Correct method call
        reserveAuction.subscribe(bidder1); // Correct method call
        reserveAuction.subscribe(bidder2); // Correct method call

        System.out.println("== Standard Auction ==");
        ((AuctionTemp) standardAuction).conductAuction(); // Cast to AuctionTemp for template method

        System.out.println("\n== Reserve Auction ==");
        ((AuctionTemp) reserveAuction).conductAuction(); // Cast to AuctionTemp for template method

        reserveAuction.unsubscribe(bidder2);

        System.out.println("\n== Reserve Auction (After Unsubscribe) ==");
        ((AuctionTemp) reserveAuction).conductAuction(); // Cast to AuctionTemp for template method
    }
}
