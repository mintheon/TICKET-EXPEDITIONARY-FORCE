package com.ticket.captain.festivalDetail;

import com.ticket.captain.festival.Festival;
import com.ticket.captain.salesType.SalesType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity(name = "festival_detail")
@Getter
public class FestivalDetail {

    @Id
    @GeneratedValue
    @Column(name = "festival_sq")
    private Long id;

    @Column(name = "perform_datetime")
    private LocalDateTime processDate;

    @Column(name = "ticket_amount")
    private Long amount;

    @Column(name = "ticket_price")
    private Long price;

    @Column(name = "draw_date")
    private LocalDateTime drawDate;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_id")
    private Long createId;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @Column(name = "modify_id")
    private Long modifyId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_type_id")
    private SalesType salesType;

    //@OneToMany(mappedBy = "festivalDetail")
    //private List<Order> orders = new ArrayList<>();

    public FestivalDetail() {

    }

    @Builder
    private FestivalDetail(Long id, LocalDateTime processDate, Long amount, Long price, LocalDateTime drawDate, LocalDateTime createDate, Long createId, LocalDateTime modifyDate, Long modifyId, Festival festival, SalesType salesType) {
        this.id = id;
        this.processDate = processDate;
        this.amount = amount;
        this.price = price;
        this.drawDate = drawDate;
        this.createDate = createDate;
        this.createId = createId;
        this.modifyDate = modifyDate;
        this.modifyId = modifyId;
        this.festival = festival;
        this.salesType = salesType;
    }


    public void update(LocalDateTime processDate, Long amount, Long price, LocalDateTime drawDate, LocalDateTime modifyDate, Long modifyId, SalesType salesType) {
        this.processDate = processDate;
        this.amount = amount;
        this.price = price;
        this.drawDate = drawDate;
        this.modifyDate = modifyDate;
        this.modifyId = modifyId;
        this.salesType = salesType;
    }
}