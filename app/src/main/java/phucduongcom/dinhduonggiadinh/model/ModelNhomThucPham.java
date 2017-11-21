package phucduongcom.dinhduonggiadinh.model;

/**
 * Created by phucd on 11/21/2017.
 */

public class ModelNhomThucPham {
    private String Name;
    private int IDimage;

    public ModelNhomThucPham(String name, int IDimage) {
        Name = name;
        this.IDimage = IDimage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIDimage() {
        return IDimage;
    }

    public void setIDimage(int IDimage) {
        this.IDimage = IDimage;
    }
}
