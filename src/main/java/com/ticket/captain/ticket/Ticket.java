package com.ticket.captain.ticket;

import com.ticket.captain.common.BaseEntity;
import com.ticket.captain.festivalDetail.FestivalDetail;
import com.ticket.captain.order.Order;
import com.ticket.captain.enumType.StatusCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_detail_id")
    private FestivalDetail festivalDetail;

    @Column(nullable = false)
    private String ticketNo;

    private String statusCode;

    @Column(nullable = false)
    private Long price;

    @Builder
    private Ticket(String ticketNo, String statusCode, Long price) {
        this.ticketNo = ticketNo;
        this.statusCode = statusCode;
        this.price = price;
    }

    public void update(String statusCode) {
        this.statusCode = statusCode;
    }

    public void orderSetting(Order order) {
        this.order = order;
    }

    public void festivalDetailSetting(FestivalDetail festivalDetail) {
        this.festivalDetail = festivalDetail;
    }
}