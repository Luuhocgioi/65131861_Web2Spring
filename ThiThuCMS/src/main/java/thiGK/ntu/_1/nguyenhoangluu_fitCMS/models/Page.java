package thiGK.ntu._1.nguyenhoangluu_fitCMS.models;

public class Page {
    private int id;
    private String pageName;
    private String keyword;
    private String content;
    private int parentPageId;

    // PHẢI CÓ: Constructor để tạo đối tượng
    public Page(int id, String pageName, String keyword, String content, int parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }

    // PHẢI CÓ: Các Getter để Thymeleaf lấy được dữ liệu
    public int getId() { return id; }
    public String getPageName() { return pageName; }
    public String getKeyword() { return keyword; }
    public String getContent() { return content; }
    public int getParentPageId() { return parentPageId; }
}
