package pojos;

public class PojoJsonPlaceholder {

    // 1- Tum variable'lari private olarak olustur
    private String title;
    private String body;
    private int userId;
    private int id;


    // 2- Tum variable'lar icin getter ve setter metodlari olustur
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    // 3- Tum parametreleri kullanarak bir constructor olustur
    public PojoJsonPlaceholder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olustur
    public PojoJsonPlaceholder() {
    }


    // 5- toString methodu olustur
    @Override
    public String toString() {
        return "PojoJsonPlaceholder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
