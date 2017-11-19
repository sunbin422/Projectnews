import Ink.ink;
import page.page;

/**
 * Created by sunbin on 2017/7/24.
 */
public class Print {
    private ink page;
   private page pages;

    public ink getPage() {
        return page;
    }

    public void setPage(ink page) {
        this.page = page;
    }

    public page getPages() {
        return pages;
    }

    public void setPages(page pages) {
        this.pages = pages;
    }

    public void Show(){

       System.out.println( page.ink()+pages.page());
   }
}
