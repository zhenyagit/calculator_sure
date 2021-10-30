package org.imjs_man.calculator_sure.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
public class PairDepth {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String fToken;
    private String sToken;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String asks;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String bids;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfToken() {
        return fToken;
    }

    public void setfToken(String fToken) {
        this.fToken = fToken;
    }

    public String getsToken() {
        return sToken;
    }

    public void setsToken(String sToken) {
        this.sToken = sToken;
    }

    public String getAsks() {
        return asks;
    }

    public void setAsks(String asks) {
        this.asks = asks;
    }

    public String getBids() {
        return bids;
    }

    public void setBids(String bids) {
        this.bids = bids;
    }
}
