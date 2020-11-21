package com.epam.basket;

import com.epam.basket.entity.Ball;
import com.epam.basket.entity.Basket;
import com.epam.basket.entity.Color;
import com.epam.basket.service.BasketService;
import com.epam.basket.service.NoSuchElementsException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasketServiceTest {

    private BasketService service;
    private Basket basket;

    @BeforeTest
    private void initializeBalls(){
        Ball[] balls = new Ball[]{
                new Ball(Color.GREEN, 400),
                new Ball(Color.BLUE, 200),
                new Ball(Color.BLUE, 300),
                new Ball(Color.ORANGE, 900),
                new Ball(Color.BLUE, 500),
                new Ball(Color.PURPLE, 350)
        };
        service = new BasketService();
        basket = new Basket(balls);
    }

    @Test
    public void countWeightTest(){
        int actual = service.countWeight(basket);
        int expected = 2650;
        assertEquals(actual, expected);
    }

    @Test
    public void amountBallsOneColorTest(){
        int actual = service.amountBallsOneColor(basket, Color.BLUE);
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void weightSortTest(){
        Ball[] expected = new Ball[]{
                new Ball(Color.BLUE, 200),
                new Ball(Color.BLUE, 300),
                new Ball(Color.PURPLE, 350),
                new Ball(Color.GREEN, 400),
                new Ball(Color.BLUE, 500),
                new Ball(Color.ORANGE, 900)
        };
        boolean condition = true;
        service.weightSort(basket);
        Ball[] balls = basket.getBalls();
        for(int i = 0; i < balls.length; i++){
            if(balls[i].getWeight() != expected[i].getWeight()){
                condition = false;
            }
        }
        assertTrue(condition);
    }

    @Test
    public void colorSortTest(){
        Ball[] expected = new Ball[]{
                new Ball(Color.ORANGE, 900),
                new Ball(Color.GREEN, 400),
                new Ball(Color.BLUE, 200),
                new Ball(Color.BLUE, 300),
                new Ball(Color.BLUE, 500),
                new Ball(Color.PURPLE, 350)
        };
        boolean condition = true;
        service.colorSort(basket);
        Ball[] balls = basket.getBalls();
        for(int i = 0; i < balls.length; i++){
            if(balls[i].getColor() != expected[i].getColor()){
                condition = false;
            }
        }
        assertTrue(condition);
    }

    @Test
    public void findBallsByColorTest() throws NoSuchElementsException {
        Ball[] balls = service.findBallsByColor(basket, Color.BLUE);
        boolean condition = true;
        int i = 0;
        while(i < balls.length && condition){
            if(balls[i].getColor() != Color.BLUE){
                condition = false;
            }
            i++;
        }
        assertTrue(condition);
    }

    @Test
    public void findBallsByWeightTest() throws NoSuchElementsException {
        Ball[] balls = service.findBallsByWeight(basket, 200);
        boolean condition = true;
        int i = 0;
        while(i < balls.length && condition){
            if(balls[i].getWeight() != 200){
                condition = false;
            }
            i++;
        }
        assertTrue(condition);
    }

}
