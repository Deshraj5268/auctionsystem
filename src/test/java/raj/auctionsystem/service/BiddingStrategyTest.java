package raj.auctionsystem.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import raj.auctionsystem.dto.AuctionResponse;
import raj.auctionsystem.dto.BidderInformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("BiddingStrategy")
public class BiddingStrategyTest {

    private BiddingStrategy biddingStrategy;

    private final String auctionItemName="Car";

    @BeforeEach
    public void before(){
        biddingStrategy = new BiddingStrategy();
    }

    @Test
    @DisplayName("verifyTopTwoBidder")
    public void biddingWinner(){
        BidderInformation bidder1 = new BidderInformation("Pawan",new BigDecimal(1),new BigDecimal(2),new BigDecimal(10),1);
        BidderInformation bidder2 = new BidderInformation("Raj",new BigDecimal(1),new BigDecimal(2),new BigDecimal(15),2);
        BidderInformation bidder3 = new BidderInformation("Yasin",new BigDecimal(1),new BigDecimal(3),new BigDecimal(13),3);
        List<BidderInformation> bidders = new ArrayList<>();
        bidders.add(bidder1);
        bidders.add(bidder2);
        bidders.add(bidder3);
        List<BidderInformation> list = biddingStrategy.findTwoHighestBidder(bidders);
        assertEquals(list.get(0).getBidderName(),"Raj");
        assertEquals(list.get(1).getBidderName(),"Yasin");
    }

    @Test
    @DisplayName("verifyWinnerAmount")
    public void calculateWinningAmount(){
        BidderInformation bidder1 = new BidderInformation("Pawan",new BigDecimal(1),new BigDecimal(2),new BigDecimal(10),1);
        BidderInformation bidder2 = new BidderInformation("Raj",new BigDecimal(1),new BigDecimal(2),new BigDecimal(15),2);
        BidderInformation bidder3 = new BidderInformation("Yasin",new BigDecimal(1),new BigDecimal(3),new BigDecimal(13),3);
        List<BidderInformation> bidders = new ArrayList<>();
        bidders.add(bidder1);
        bidders.add(bidder2);
        bidders.add(bidder3);
        AuctionResponse auctionResponse = biddingStrategy.getAuctionWinner(auctionItemName,bidders);
        assertEquals(auctionResponse.getBidderName(),"Raj");
        assertEquals(auctionResponse.getWinningAmount(),new BigDecimal(13));
    }
}
