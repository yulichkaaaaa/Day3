package com.epam.basket.entity;

public class Basket {

    private Ball[] balls;

    public Basket(Ball[] balls) {
        this.balls =  balls;
    }

    public Basket(){}

    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }

    public Ball[] getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("balls=").append(balls);
        sb.append('}');
        return sb.toString();
    }
}
