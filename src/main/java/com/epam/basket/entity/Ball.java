package com.epam.basket.entity;

public class Ball {

    private Color color;
    private int weight;

    public Ball(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Ball(){}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("color=").append(color);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + color.ordinal();
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || (obj.getClass() != this.getClass())){
            return false;
        }
        Ball ball = (Ball)obj;
        return ((ball.color != null) && color.equals(ball.color)) &&
                (weight == ball.weight);
    }
}
