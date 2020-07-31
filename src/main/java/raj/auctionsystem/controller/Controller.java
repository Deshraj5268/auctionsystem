package raj.auctionsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raj.auctionsystem.dto.AuctionRequest;
import raj.auctionsystem.service.AuctionService;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/api/auction",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private AuctionService auctionService;

    @PostMapping("v1/auction-item-information")
    public ResponseEntity<?> getAuctionWinner(@RequestBody @Valid AuctionRequest auctionRequest){
       return new ResponseEntity<>(auctionService.getWinner(auctionRequest), HttpStatus.OK);
    }
}
