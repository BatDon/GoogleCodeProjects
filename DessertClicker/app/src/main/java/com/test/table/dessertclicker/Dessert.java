package com.test.table.dessertclicker;

public class Dessert {
    int imageId;
    int price;
    int productionAmount;

    public Dessert(int imageId, int price, int productionAmount){
        this.imageId=imageId;
        this.price=price;
        this.productionAmount=productionAmount;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductionAmount() {
        return productionAmount;
    }

    public void setProductionAmount(int productionAmount) {
        this.productionAmount = productionAmount;
    }
}
