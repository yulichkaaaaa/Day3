package com.epam.basket.service;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;

public class BasketService{

    public int countWeight(Basket basket){
        Ball[] balls = basket.getBalls();
        int weight = 0;
        for(Ball ball : balls){
            weight += ball.getWeight();
        }
        return weight;
    }

    public int amountBallsOneColor(Basket basket, Color ballColor){
        Ball[] balls = basket.getBalls();
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
        Ball[] balls = basket.getBalls();
        Ball min, temp;
        int minInd;
        for(int i = 0; i < balls.length; i++){
            min = balls[i];
            minInd = i;
            for(int j = i + 1; j < balls.length; j++){
                if(balls[j].getWeight() < min.getWeight()){
                    min = balls[j];
                    minInd = j;
                }
            }
            temp = balls[i];
            balls[i] = balls[minInd];
            balls[minInd] = temp;
        }
        basket.setBalls(balls);
    }

    public void colorSort(Basket basket){
        Ball[] balls = basket.getBalls();
        Ball current;
        for(int i = 1; i < balls.length; i++){
            current = balls[i];
            int j = i - 1;
            while(j >= 0 && (balls[j].getColor().ordinal() > current.getColor().ordinal())){
                balls[j + 1] = balls[j];
                j--;
            }
            balls[j + 1] = current;
        }
        basket.setBalls(balls);
    }

    public Ball[] findBallsByColor(Basket basket, Color color) throws NoSuchElementsException{
        Ball[] balls = basket.getBalls();
        int count = amountBallsOneColor(basket, color);
        if(count == 0){
            throw new NoSuchElementsException("there is no balls of this color.");
        }
        Ball[] coloredBalls = new Ball[count];
        int ind = 0;
        for (Ball ball : balls){
            if(ball.getColor() == color) {
                coloredBalls[ind] = ball;
                ind++;
            }
        }
        return coloredBalls;
    }

    public Ball[] findBallsByWeight(Basket basket, int weight) throws NoSuchElementsException{
        Ball[] balls = basket.getBalls();
        int count = 0;
        for (Ball ball : balls){
            if(ball.getWeight() == weight){
                count++;
            }
        }
        if(count == 0){
            throw new NoSuchElementsException("there is no balls of this weight.");
        }
        Ball[] outputBalls = new Ball[count];
        int ind = 0;
        for (Ball ball : balls){
            if(ball.getWeight() == weight) {
                outputBalls[ind] = ball;
                ind++;
            }
        }
        return outputBalls;
    }
}
