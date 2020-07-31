package raj.auctionsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Objects;

public final class AuctionResponse {

    @JsonProperty("auctionItemName")
    private final String auctionItemName;

    @JsonProperty("bidderName")
    private final String bidderName;

    @JsonProperty("winningAmount")
    private final BigDecimal winningAmount;

    public AuctionResponse(@NonNull String auctionItemName, String bidderName, BigDecimal winningAmount) {
        this.auctionItemName = auctionItemName;
        this.bidderName = bidderName;
        this.winningAmount = winningAmount;
    }

    public String getAuctionItemName() {
        return auctionItemName;
    }


    public String getBidderName() {
        return bidderName;
    }


    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionResponse that = (AuctionResponse) o;
        return auctionItemName.equals(that.auctionItemName) &&
                bidderName.equals(that.bidderName) &&
                winningAmount.equals(that.winningAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionItemName, bidderName, winningAmount);
    }
}
