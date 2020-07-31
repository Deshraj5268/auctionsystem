package raj.auctionsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class BidderInformation implements Comparable<BidderInformation>{

    @NotNull
    @JsonProperty("BidderName")
    private final String BidderName;

    @NotNull
    @JsonProperty("startBid")
    private final BigDecimal startBid;

    @NotNull
    @JsonProperty("autoIncrementBid")
    private final BigDecimal autoIncrementBid;

    @NotNull
    @JsonProperty("maxBid")
    private final BigDecimal maxBid;

    @NotNull
    @JsonProperty("startBidTime")
    private final long startBidTime;


    public BidderInformation(@NotNull String BidderName, @NotNull BigDecimal startBid, @NotNull BigDecimal autoIncrementBid, @NotNull BigDecimal maxBid, long startBidTime) {
        this.BidderName = BidderName;
        this.startBid = startBid;
        this.autoIncrementBid = autoIncrementBid;
        this.maxBid = maxBid;
        this.startBidTime = startBidTime;
    }

    @NotNull
    public String getBidderName() {
        return BidderName;
    }

    @NotNull
    public BigDecimal getStartBid() {
        return startBid;
    }

    @NotNull
    public BigDecimal getAutoIncrementBid() {
        return autoIncrementBid;
    }

    @NotNull
    public BigDecimal getMaxBid() {
        return maxBid;
    }

    public long getStartBidTime() {
        return startBidTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BidderInformation that = (BidderInformation) o;
        return startBidTime == that.startBidTime &&
                BidderName.equals(that.BidderName) &&
                startBid.equals(that.startBid) &&
                autoIncrementBid.equals(that.autoIncrementBid) &&
                maxBid.equals(that.maxBid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BidderName, startBid, autoIncrementBid, maxBid, startBidTime);
    }

    @Override
    public int compareTo(BidderInformation o) {
        int compVal = this.getHighestPossibleBid().compareTo(o.getHighestPossibleBid());
        if(compVal == 0 && this.getStartBidTime() < o.getStartBidTime()){
            return compVal;
        }
        return compVal;
    }

    public BigDecimal getHighestPossibleBid(){
        return this.getStartBid().add(this.getAutoIncrementBid().multiply(this.getMaxBid().subtract(this.getStartBid()).divide(this.getAutoIncrementBid(), RoundingMode.FLOOR)));
    }
}
