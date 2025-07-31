package example.day02.실습.실습1;

public class BoardDto {
    private int bon;
    private String btitle;

    public BoardDto(int bon, String btitle) {
        this.bon = bon;
        this.btitle = btitle;
    }

    public BoardDto() {
    }

    public int getBon() {
        return bon;
    }

    public void setBon(int bon) {
        this.bon = bon;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
}//class e
