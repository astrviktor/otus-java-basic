package animals;

public abstract class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int stamina;
    int staminaRunCost;
    int staminaSwimCost;

    public Animal(String name, int speedRun, int speedSwim, int stamina, int staminaRunCost, int staminaSwimCost) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.stamina = stamina;
        this.staminaRunCost = staminaRunCost;
        this.staminaSwimCost = staminaSwimCost;
    }

    public float run(int distance) {
        if (staminaRunCost <= 0) {
            System.out.println(name + " не умеет бегать");
            return -1.0f;
        }

        int staminaCost = staminaRunCost * distance;

        if (staminaCost >= stamina) {
            System.out.println(name + " не хватило выносливости пробежать " + distance + " метров, перешел в состояние усталости");
            stamina = 0;
            return -1.0f;
        }

        stamina -= staminaCost;
        float time = (float) distance / speedRun;
        System.out.println(name + " пробежал " + distance + " метров за " + time + " секунд, потратив " + staminaCost + " выносливости");
        return time;
    }
    public float swim(int distance) {
        if (staminaSwimCost <= 0) {
            System.out.println(name + " не умеет плавать");
            return -1.0f;
        }

        int staminaCost = staminaSwimCost * distance;

        if (staminaCost >= stamina) {
            System.out.println(name + " не хватило выносливости проплыть " + distance + " метров, перешел в состояние усталости");
            stamina = 0;
            return -1.0f;
        }

        stamina -= staminaCost;

        float time = (float) distance / speedSwim;
        System.out.println(name + " проплыл " + distance + " метров за " + time + " секунд, потратив " + staminaCost + " выносливости");
        return time;
    }

    public void info() {
        if (stamina > 0) {
            System.out.println(name + " в состояние бодрости, осталось выносливости: " + stamina);
        } else {
            System.out.println(name + " в состояние усталости");
        }
    }
}
