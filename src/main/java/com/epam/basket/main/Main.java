package com.epam.basket.main;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;
import com.epam.basket.report.BasketReport;
import com.epam.basket.service.BasketService;
import com.epam.basket.service.NoSuchElementsException;

public class Main {
    public static void main(String[] args) {
        Ball[] balls = new Ball[]{
                new Ball(Color.GREEN, 400),
                new Ball(Color.BLUE, 200),
                new Ball(Color.BLUE, 300),
                new Ball(Color.ORANGE, 900),
                new Ball(Color.BLUE, 500),
                new Ball(Color.PURPLE, 300)
        };
        Basket basket = new Basket(balls);
        BasketService service = new BasketService();
        int blueBalls = service.amountBallsOneColor(basket, Color.BLUE);
        int weight = service.countWeight(basket);
        service.weightSort(basket);
        service.colorSort(basket);
        BasketReport report = new BasketReport();
        report.ballsWeight(weight);
        report.blueBallsAmount(blueBalls);
        try {
            Ball[] coloredBalls = service.findBallsByColor(basket, Color.BLUE);
            Ball[] weightBalls = service.findBallsByWeight(basket, 900);
            int i = 0;
        } catch (NoSuchElementsException e) {
            report.exceptionReport(e.getMessage());
        }
        int i = 0;

    }
}
