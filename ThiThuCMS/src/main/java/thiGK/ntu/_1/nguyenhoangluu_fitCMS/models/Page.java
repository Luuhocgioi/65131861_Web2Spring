package thiGK.ntu._1.nguyenhoangluu_fitCMS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="page")
public class Page {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="pageName")
    private String PageName;
    
    @Column(name="keyword")
    private String keyword;
    
    @Column(name="content")
    private String content;
    
    @Column(name="parentPageId")
    private int parentPageId;
    public Page() {}
    

    public Page(int id, String pageName, String keyword, String content, int parentPageId) {
        this.id = id;
        this.PageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }

    public int getId() { return id; }
    public void setId(int id) {this.id= id; }
    public String getPageName() { return PageName; }
    public void setPageName(String pageName) {this.PageName=pageName;}
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) {this.keyword=keyword;}
    public String getContent() { return content; }
    public void setContent(String content) {this.content=content;}
    public int getParentPageId() { return parentPageId; }
    public void setParentPageId(int parentPageId) {this.parentPageId=parentPageId;}
}
