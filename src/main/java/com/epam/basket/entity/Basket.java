package com.epam.basket.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Ball> balls;

    public Basket(List<Ball> balls) {
        this.balls =  new ArrayList<Ball>();
        this.balls.addAll(balls);
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(balls);
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Ball ball){
        balls.add(ball);
    }

    public void removeBall(Ball ball){
        balls.remove(ball);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("balls=").append(balls);
        sb.append('}');
        return sb.toString();
    }
}
