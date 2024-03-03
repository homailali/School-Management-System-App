package life.homail.SchoolManagementSystem.SingleTon;

import life.homail.SchoolManagementSystem.HomePage.HomeMain;

public final class SingleTon {
    // Fields
    private HomeMain homeMain;
    private static final SingleTon SINGLE_TON=new SingleTon();
    // Methods
    public static SingleTon getSingleTon(){
        return SINGLE_TON;
    }
    public HomeMain getHomeMain() {
        return homeMain;
    }
    public void setHomeMain(HomeMain homeMain) {
        this.homeMain = homeMain;
    }
}
