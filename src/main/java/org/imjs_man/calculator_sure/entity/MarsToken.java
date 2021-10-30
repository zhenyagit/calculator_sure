package org.imjs_man.calculator_sure.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class MarsToken {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String tokenToSellOrBuyName;
    private String tokenToSellOrBuySymbol;
    private String tokenToSellOrBuyImage;
    private double fundAmount;
    private double tokenToSellOrBuyPrice;
    private double quantity;
    private double discount;
    private double bids;
    private double tokenToSellOrBuyUsd;
    private double twap;
    private String offerMode;
    private String tokenToFundAddress;
    private String tokenToFundName;
    private String tokenToFundSymbol;
    private double tokenToFundPrice;
    private String createdAt;  //SimpleDateFormat
    private String actionType;
    private String offerKey;
    private String tokenToSellOrBuyAddress;
    private String orderOwnerAdress;
    private Boolean isNew;
    private Boolean isHot;
    private double maxBid;
    private int rank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTokenToSellOrBuyName() {
        return tokenToSellOrBuyName;
    }

    public void setTokenToSellOrBuyName(String tokenToSellOrBuyName) {
        this.tokenToSellOrBuyName = tokenToSellOrBuyName;
    }

    public String getTokenToSellOrBuySymbol() {
        return tokenToSellOrBuySymbol;
    }

    public void setTokenToSellOrBuySymbol(String tokenToSellOrBuySymbol) {
        this.tokenToSellOrBuySymbol = tokenToSellOrBuySymbol;
    }

    public String getTokenToSellOrBuyImage() {
        return tokenToSellOrBuyImage;
    }

    public void setTokenToSellOrBuyImage(String tokenToSellOrBuyImage) {
        this.tokenToSellOrBuyImage = tokenToSellOrBuyImage;
    }

    public double getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(double fundAmount) {
        this.fundAmount = fundAmount;
    }

    public double getTokenToSellOrBuyPrice() {
        return tokenToSellOrBuyPrice;
    }

    public void setTokenToSellOrBuyPrice(double tokenToSellOrBuyPrice) {
        this.tokenToSellOrBuyPrice = tokenToSellOrBuyPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getBids() {
        return bids;
    }

    public void setBids(double bids) {
        this.bids = bids;
    }

    public double getTokenToSellOrBuyUsd() {
        return tokenToSellOrBuyUsd;
    }

    public void setTokenToSellOrBuyUsd(double tokenToSellOrBuyUsd) {
        this.tokenToSellOrBuyUsd = tokenToSellOrBuyUsd;
    }

    public double getTwap() {
        return twap;
    }

    public void setTwap(double twap) {
        this.twap = twap;
    }

    public String getOfferMode() {
        return offerMode;
    }

    public void setOfferMode(String offerMode) {
        this.offerMode = offerMode;
    }

    public String getTokenToFundAddress() {
        return tokenToFundAddress;
    }

    public void setTokenToFundAddress(String tokenToFundAddress) {
        this.tokenToFundAddress = tokenToFundAddress;
    }

    public String getTokenToFundName() {
        return tokenToFundName;
    }

    public void setTokenToFundName(String tokenToFundName) {
        this.tokenToFundName = tokenToFundName;
    }

    public String getTokenToFundSymbol() {
        return tokenToFundSymbol;
    }

    public void setTokenToFundSymbol(String tokenToFundSymbol) {
        this.tokenToFundSymbol = tokenToFundSymbol;
    }

    public double getTokenToFundPrice() {
        return tokenToFundPrice;
    }

    public void setTokenToFundPrice(double tokenToFundPrice) {
        this.tokenToFundPrice = tokenToFundPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getOfferKey() {
        return offerKey;
    }

    public void setOfferKey(String offerKey) {
        this.offerKey = offerKey;
    }

    public String getTokenToSellOrBuyAddress() {
        return tokenToSellOrBuyAddress;
    }

    public void setTokenToSellOrBuyAddress(String tokenToSellOrBuyAddress) {
        this.tokenToSellOrBuyAddress = tokenToSellOrBuyAddress;
    }

    public String getOrderOwnerAdress() {
        return orderOwnerAdress;
    }

    public void setOrderOwnerAdress(String orderOwnerAdress) {
        this.orderOwnerAdress = orderOwnerAdress;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public double getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(double maxBid) {
        this.maxBid = maxBid;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    //
//    @ManyToMany
//    private Set<PersonEntity> personEntityList;
//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<ExerciseEntity> exerciseEntityList;
//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<QuizEntity> quizEntityList;

}
