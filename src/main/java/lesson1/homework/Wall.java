package lesson1.homework;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getResultJumping(CanJump jumper) {
        boolean ok = jumper.jump(this);
        if (ok) {
            System.out.println("Высота " + this.height + " взята");
        } else {
            System.out.println("Высота " + this.height + " не взята");
        }
        return ok;
    }
}
