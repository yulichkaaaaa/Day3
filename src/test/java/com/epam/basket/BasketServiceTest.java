package com.epam.basket;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;
import com.epam.basket.service.BasketService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {

    private List<Ball> balls;

    @BeforeTest
    private void initializeBalls(){
        balls = new ArrayList<>();
        balls.add(new Ball(Color.GREEN, 200));
        balls.add(new Ball(Color.BLUE, 400));
        balls.add(new Ball(Color.RED, 200));
        balls.add(new Ball(Color.BLUE, 300));
        balls.add(new Ball(Color.YELLOW, 900));
        balls.add(new Ball(Color.WHITE, 800));
        balls.add(new Ball(Color.BLUE, 500));
    }

    @Test
    public void countWeightTest(){
        Basket basket = new Basket(balls);
        BasketService service = new BasketService();
        int actual = service.countWeight(basket);
        int expected = 3300;
        assertEquals(actual, expected);
    }

    @Test
    public void amountBallsOneColorTest(){
        Basket basket = new Basket(balls);
        BasketService service = new BasketService();
        int actual = service.amountBallsOneColor(basket, Color.BLUE);
        int expected = 3;
        assertEquals(actual, expected);
    }

}
