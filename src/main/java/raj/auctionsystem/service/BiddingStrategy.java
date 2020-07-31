package raj.auctionsystem.service;

import org.springframework.stereotype.Component;
import raj.auctionsystem.dto.AuctionResponse;
import raj.auctionsystem.dto.BidderInformation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class BiddingStrategy {

    public AuctionResponse getAuctionWinner(String auctionItemName, List<BidderInformation> bidders){
        if(bidders.size() == 1){
            return new AuctionResponse(auctionItemName,bidders.get(0).getBidderName(),bidders.get(0).getStartBid());
        }
        List<BidderInformation> twoHighestBidder = findTwoHighestBidder(bidders);
        BigDecimal winningAmount = calculateMaxPossibleBid(twoHighestBidder.get(0),twoHighestBidder.get(1));
        return new AuctionResponse(auctionItemName,twoHighestBidder.get(0).getBidderName(),winningAmount);
    }

    public BigDecimal calculateMaxPossibleBid(BidderInformation firstBidder, BidderInformation secondBidder) {
        if(firstBidder.getStartBid().compareTo(secondBidder.getMaxBid()) >= 0){
            return firstBidder.getStartBid();
        }
        BigDecimal maxPossibleBidOfSecondBidder = secondBidder.getHighestPossibleBid();
        BigDecimal remainingMAxWiningBidOfFirstBidder = maxPossibleBidOfSecondBidder.subtract(firstBidder.getStartBid());
        BigDecimal winningBidAmount = firstBidder.getStartBid().add(firstBidder.getAutoIncrementBid().multiply(remainingMAxWiningBidOfFirstBidder.divide(firstBidder.getAutoIncrementBid(), RoundingMode.CEILING)));
        return winningBidAmount;
    }

    public List<BidderInformation> findTwoHighestBidder(List<BidderInformation> bidders) {
        BidderInformation maxBidder = bidders.get(0);
        BidderInformation secondBidder = bidders.get(1);
        if(maxBidder.compareTo(secondBidder) < 0){
            maxBidder = bidders.get(1);
            secondBidder = bidders.get(1);
        }
        BidderInformation currentBidder;
        for (int i=2;i<bidders.size();i++){
            currentBidder = bidders.get(i);
            if(maxBidder.compareTo(currentBidder) < 0){
                secondBidder = maxBidder;
                maxBidder = currentBidder;
            }else if(secondBidder.compareTo(currentBidder) < 0){
                secondBidder = currentBidder;
            }
        }
        List<BidderInformation> twoHighestBidder = new ArrayList<>();
        twoHighestBidder.add(maxBidder);
        twoHighestBidder.add(secondBidder);
        return twoHighestBidder;
    }
}
