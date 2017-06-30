package entity;

/**
 * Created by nextre0029 on 30/06/2017.
 */
public class Service_Auto {
    private Auto auto;

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Service_Auto() {


    }

    public Auto venditaAuto(Auto a) {
        if (a.getKilometri() >= 100_000) {
            System.out.println("Auto venduta");
            return auto;
        } else {
            System.out.println(" Auto non disponibile! ");
        }
        return null;
    }

}
