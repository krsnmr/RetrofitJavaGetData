/**
 * Класс для тестирования сервиса https://jsonplaceholder.typicode.com
 */
public class Post {

    int id;
    int userId;
    String title;
    String body;

    public Post(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
