package irnss.com;

public class Square implements Shape{

    Square(){
        System.out.println("I'm a SQUARE");
    }
    @Override
    public void draw () {
        System.out.println("I'm a Square");
    }

}

