package pojos;

public class PojoHerokuappResponseBody {

    // 1- Tum variable'lari private olarak olustur
    private int bookingId;
    private PojoHerokuappRequestBody booking;


    // 2- Tum variable'lar icin getter ve setter metodlari olustur
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }


    // 3- Tum parametreleri kullanarak bir constructor olustur
    public PojoHerokuappResponseBody(int bookingId, PojoHerokuappRequestBody booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }


    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olustur
    public PojoHerokuappResponseBody() {
    }

    // 5- toString methodu olustur
    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
