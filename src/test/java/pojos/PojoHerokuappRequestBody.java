package pojos;

public class PojoHerokuappRequestBody {

    // 1- Tum variable'lari private olarak olustur
    private String firstname;
    private String lastname;
    private int totalprice ;
    private boolean depositpaid;
    private PojoHerokuappBookingdates bookingdates;
    private String additionalneeds; ;


    // 2- Tum variable'lar icin getter ve setter metodlari olustur
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerokuappBookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerokuappBookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    // 3- Tum parametreleri kullanarak bir constructor olustur
    public PojoHerokuappRequestBody(String firstname, String additionalneeds, PojoHerokuappBookingdates bookingdates, boolean depositpaid, int totalprice, String lastname) {
        this.firstname = firstname;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
        this.depositpaid = depositpaid;
        this.totalprice = totalprice;
        this.lastname = lastname;
    }


    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olustur
    public PojoHerokuappRequestBody() {
    }


    // 5- toString methodu olustur
    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
