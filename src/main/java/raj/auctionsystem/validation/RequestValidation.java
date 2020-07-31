package raj.auctionsystem.validation;

import org.springframework.stereotype.Component;
import raj.auctionsystem.dto.AuctionRequest;
import raj.auctionsystem.dto.BidderInformation;

import java.math.BigDecimal;

@Component
public class RequestValidation {

    private boolean isRequestEmpty(BidderInformation bidderInformation){
        if((bidderInformation.getStartBid() != null && BigDecimal.ZERO.compareTo(bidderInformation.getStartBid()) > 0)
            || (bidderInformation.getAutoIncrementBid() != null && BigDecimal.ZERO.compareTo(bidderInformation.getAutoIncrementBid()) > 0)
            || (bidderInformation.getMaxBid() != null && BigDecimal.ZERO.compareTo(bidderInformation.getMaxBid()) > 0)
            ||(bidderInformation.getBidderName() != null)){
            return false;
        }
        return true;
    }

    public boolean isValidateRequest(AuctionRequest auctionRequest){
        if(auctionRequest.getAuctionItemName() == null){
            return false;
        }
        if(auctionRequest.getBidders() != null){
            for (BidderInformation  bidderInformation: auctionRequest.getBidders()){
                if(!isRequestEmpty(bidderInformation)){
                    return false;
                }
            }
        }
        return true;
    }
}
