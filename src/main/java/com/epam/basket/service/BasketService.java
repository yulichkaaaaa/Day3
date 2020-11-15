package com.epam.basket.service;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;

import java.util.List;

public class BasketService {

    public int countWeight(Basket basket){
        List<Ball> balls = basket.getBalls();
        int weight = 0;
        for(Ball ball : balls){
            weight += ball.getWeight();
        }
        return weight;
    }

    public int amountBlueBalls(Basket basket){
        List<Ball> balls = basket.getBalls();
        int count = 0;
        Color color;
        for(Ball ball : balls){
            color = ball.getColor();
            if(color == Color.BLUE){
                count++;
            }
        }
        return count;
    }
}
