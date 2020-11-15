package com.epam.basket.main;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;
import com.epam.basket.report.BasketReport;
import com.epam.basket.service.BasketService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Ball> balls = new ArrayList<Ball>();
        balls.add(new Ball(Color.GREEN, 200));
        balls.add(new Ball(Color.BLUE, 400));
        balls.add(new Ball(Color.RED, 200));
        balls.add(new Ball(Color.BLUE, 300));
        balls.add(new Ball(Color.YELLOW, 900));
        balls.add(new Ball(Color.WHITE, 800));
        balls.add(new Ball(Color.BLUE, 500));

        Basket basket = new Basket(balls);
        BasketService service = new BasketService();
        int blueBalls = service.amountBlueBalls(basket);
        int weight = service.countWeight(basket);

        BasketReport report = new BasketReport();
        report.ballsWeight(weight);
        report.blueBallsAmount(blueBalls);
    }
}
