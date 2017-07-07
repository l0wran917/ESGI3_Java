package Food;

import Main.Model;

import javax.swing.*;
import java.awt.*;

public class Food extends Model {

    private int maxQty = 50;

    private int qty;

    public Food(Point position){
        super(position);
        this.qty = this.maxQty;
        this.view = new FoodView(this);
    }

    public int getMaxQty(){
        return this.maxQty;
    }

    public int getQty(){
        return this.qty;
    }

    public void removeQty(){
        this.qty -= 1;
    }
}
