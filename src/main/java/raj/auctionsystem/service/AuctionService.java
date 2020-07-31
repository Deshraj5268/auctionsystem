package raj.auctionsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raj.auctionsystem.dto.AuctionRequest;
import raj.auctionsystem.dto.AuctionResponse;
import raj.auctionsystem.exception.ApplicationException;
import raj.auctionsystem.exception.CustomMessage;
import raj.auctionsystem.validation.RequestValidation;

@Service
public class AuctionService {

    @Autowired
    private BiddingStrategy biddingStrategy;

    @Autowired
    private RequestValidation requestValidation;

    public AuctionResponse getWinner(AuctionRequest auctionRequest){
        //validation

        if(!requestValidation.isValidateRequest(auctionRequest)){
            throw new ApplicationException(new CustomMessage("E205","please provide required params "));
        }

        AuctionResponse auctionResponse = biddingStrategy.getAuctionWinner(auctionRequest.getAuctionItemName(),auctionRequest.getBidders());
        return auctionResponse;
    }
}
