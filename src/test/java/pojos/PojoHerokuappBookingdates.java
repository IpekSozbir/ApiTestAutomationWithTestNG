package pojos;

public class PojoHerokuappBookingdates {

    // 1- Tum variable'lari private olarak olustur
    private String checkin;
    private String checkout;

    // 2- Tum variable'lar icin getter ve setter metodlari olustur
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    // 3- Tum parametreleri kullanarak bir constructor olustur
    public PojoHerokuappBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olustur
    public PojoHerokuappBookingdates() {
    }


    // 5- toString methodu olustur
    @Override
    public String toString() {
        return "PojoHerokuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
