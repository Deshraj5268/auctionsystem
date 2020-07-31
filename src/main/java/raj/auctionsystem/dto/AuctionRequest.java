package raj.auctionsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AuctionRequest {

    @NotNull
    @JsonProperty("auctionItemName")
    private final String auctionItemName;

    @NotNull
    @JsonProperty("bidders")
    private final List<BidderInformation> bidders;

    public AuctionRequest( @NotNull String auctionItemName,  @NotNull List<BidderInformation> bidders) {
        this.auctionItemName = auctionItemName;
        this.bidders = new ArrayList<>(bidders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionRequest that = (AuctionRequest) o;
        return auctionItemName.equals(that.auctionItemName) &&
                bidders.equals(that.bidders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionItemName, bidders);
    }

    @NotNull
    public String getAuctionItemName() {
        return auctionItemName;
    }

    @NotNull
    public List<BidderInformation> getBidders() {
        return bidders;
    }
}
