package homework1;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/5
 * @project: leaderlearing
 * @packageName: homework1
 * @description: XXXXXX
 */
public class Salary {
    private String name;
    private int baseSalary;
    private int bonus;

    private static final Random RANDOM = ThreadLocalRandom.current();

    public Salary() {
        this.name =UUID.randomUUID().toString().substring(0,5) ;
        this.baseSalary = RANDOM.nextInt(100*10000)+50000;
        this.bonus = RANDOM.nextInt(100000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Integer getCompareFiled(){
        return this.getBaseSalary()*13+this.getBonus();
    }
}
