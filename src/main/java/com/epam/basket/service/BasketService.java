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

    public int amountBallsOneColor(Basket basket, Color ballColor){
        List<Ball> balls = basket.getBalls();
        int count = 0;
        Color color;
        for(Ball ball : balls){
            color = ball.getColor();
            if(color == ballColor){
                count++;
            }
        }
        return count;
    }

    public void weightSort(Basket basket){
        List<Ball> balls= basket.getBalls();
        Ball min, temp;
        int minInd = 0;
        for(int i = 0; i < balls.size(); i++){
            min = balls.get(i);
            minInd = i;
            for(int j = i + 1; j < balls.size(); j++){
                if(balls.get(j).getWeight() < min.getWeight()){
                    min = balls.get(j);
                    minInd = j;
                }
            }
            temp = balls.remove(i);
            balls.add(i, min);
            balls.remove(minInd);
            balls.add(minInd, temp);
        }
        basket.setBalls(balls);
    }

    public void colorSort(Basket basket){
        List<Ball> balls= basket.getBalls();
        Ball current;
        for(int i = 1; i < balls.size(); i++){
            current = balls.get(i);
            int j = i - 1;
            while(j >= 0 && (balls.get(j).getColor().ordinal() > current.getColor().ordinal())){
                balls.add(j+1, balls.get(j));
                balls.remove(j);
                j--;
            }
            balls.add(j+1, current);
            balls.remove(balls.lastIndexOf(current));
        }
        basket.setBalls(balls);
    }

}
