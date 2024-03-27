package hello.springcore.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discontPrice;

    public int calculatePrice(){
        return itemPrice - discontPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discontPrice=" + discontPrice +
                '}';
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscontPrice() {
        return discontPrice;
    }

    public void setDiscontPrice(int discontPrice) {
        this.discontPrice = discontPrice;
    }
    public Order(Long memberId, String itemName, int itemPrice, int discontPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discontPrice = discontPrice;
    }

}
