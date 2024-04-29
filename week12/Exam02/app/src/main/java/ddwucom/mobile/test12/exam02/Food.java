package ddwucom.mobile.test12.exam02;

import java.io.Serializable;

public class Food implements Serializable{ // serializable 을 이용하여 food 객체를 intent 로 넘겨준다.
    String food;
    String nation;


    public Food(String food, String nation) {
        this.food = food;
        this.nation = nation;
    }

    public String getFood() {
        return food;
    }

    public String getNation() {
        return nation;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return food + "\t\t(" + nation + ")";
    }

}
