package com.tkdgus.springstudy.domain;

public class Order {
    private Long id;

    private String itemName;
    private Member member;
    private int originPrice;
    private int discountPrice;

    public Order() {
    }

    public Order(Long id, String itemName, Member member, int originPrice, int discountPrice) {
        this.id = id;
        this.itemName = itemName;
        this.member = member;
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", member=" + member +
            ", originPrice=" + originPrice +
            ", discountPrice=" + discountPrice +
            '}';
    }
}
